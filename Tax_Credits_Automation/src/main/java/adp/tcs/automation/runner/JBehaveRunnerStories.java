package adp.tcs.automation.runner;

import adp.tcs.automation.utilities.PropertiesUtilities;
import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.context.Context;
import org.jbehave.core.context.ContextView;
import org.jbehave.core.context.JFrameContextView;
import org.jbehave.core.embedder.PropertyBasedEmbedderControls;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.model.ExamplesTableFactory;
import org.jbehave.core.model.TableTransformers;
import org.jbehave.core.parsers.RegexPrefixCapturingPatternParser;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.ContextOutput;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.*;
import org.jbehave.core.steps.ParameterConverters.DateConverter;
import org.jbehave.core.steps.ParameterConverters.ExamplesTableConverter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
import static org.jbehave.core.reporters.Format.*;


/**
 * <p>
 * Example of how multiple stories can be run via JUnit.
 * </p>
 * <p>
 * Stories are specified in classpath and correspondingly the
 * {@link LoadFromClasspath} story loader is configured.
 * </p>
 */
/**test**/

 public class JBehaveRunnerStories extends JUnitStories {

        private final CrossReference xref = new CrossReference();
        private Context context = new Context();
        private Format contextFormat = new ContextOutput(context);
        private ContextView contextView = new JFrameContextView().sized(450, 125);
        private ContextStepMonitor contextStepMonitor = new ContextStepMonitor(context, contextView, xref.getStepMonitor());


        public JBehaveRunnerStories() {
            configuredEmbedder().embedderControls().doGenerateViewAfterStories(true).doIgnoreFailureInStories(false)
                    .doIgnoreFailureInView(true).doVerboseFailures(true).useThreads(2).useStoryTimeoutInSecs(60);
            configuredEmbedder().useEmbedderControls(new PropertyBasedEmbedderControls());
        }

    public Configuration configuration() {
        // avoid re-instantiating configuration for the steps factory
        // alternative use #useConfiguration() in the constructor
        if (super.configuration() != null) {
            return super.configuration();
        }
        Class<? extends Embeddable> embeddableClass = this.getClass();
        Properties viewResources = new Properties();
        viewResources.put("decorateNonHtml", "true");
        viewResources.put("reports", "ftl/jbehave-reports.ftl");
        // Start from default ParameterConverters instance
        ParameterConverters parameterConverters = new ParameterConverters();
        // factory to allow parameter conversion and loading from external
        // resources (used by StoryParser too)
        ExamplesTableFactory examplesTableFactory = new ExamplesTableFactory(new LocalizedKeywords(),
                new LoadFromClasspath(embeddableClass), parameterConverters, new TableTransformers());
        // add custom converters
        parameterConverters.addConverters(new DateConverter(new SimpleDateFormat("yyyy-MM-dd")),
                new ExamplesTableConverter(examplesTableFactory));
        return new MostUsefulConfiguration()
                .useStoryLoader(new LoadFromClasspath(embeddableClass))
                .useStoryParser(new RegexStoryParser(examplesTableFactory))
                .useStoryReporterBuilder(
                        new StoryReporterBuilder()
                                .withCodeLocation(codeLocationFromClass(embeddableClass))
                                .withDefaultFormats().withViewResources(viewResources)
                                .withFormats(contextFormat, CONSOLE, TXT, HTML_TEMPLATE, XML_TEMPLATE).withFailureTrace(true)
                                .withFailureTraceCompression(true).withCrossReference(xref))
                .useParameterConverters(parameterConverters)
                // use '%' instead of '$' to identify parameters
                .useStepPatternParser(new RegexPrefixCapturingPatternParser("%"))
                .useStepMonitor(contextStepMonitor);
    }


   /* @Override
    public InjectableStepsFactory stepsFactory() {
        // MyContext context = new MyContext();
        StepsObject allObject = new StepsObject();
        ArrayList<Steps> stepFileList = new ArrayList<Steps>();
        return new InstanceStepsFactory(configuration(), allObject.addObjects());
    }*/


    @Override
    protected List<String> storyPaths() {       
        String storypath = (PropertiesUtilities.loadKeyValue("storyPath"));
        String filter = System.getProperty("story.filter", "**"+ storypath +"/**.story");
        System.out.println("value for filter :" + filter);
        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), filter, "**/failing_before*.story,**/given_relative_path*");
        }

//    @Override
//    protected List<String> storyPaths() {
//
//       String storyProperty = System.getProperty("story");
//        List<String> storiesToRun = new ArrayList<String>();
//        if (storyProperty == null) {
//            throw new RuntimeException("Please specify which stories to run");
//        }
//        //List<String> storyNames = Arrays.asList(storyProperty.split(","));
//        String[] storyNames = storyProperty.split(",");
//        StoryFinder sf = new StoryFinder();
//        URL baseUrl = CodeLocations.codeLocationFromClass(this.getClass());
//        System.out.println("base url is : " + baseUrl);
//
//        for (String storyName : storyNames) {
//            storiesToRun.addAll(sf.findPaths(baseUrl, storyName, ""));
//    System.out.println("value for filter :" + storiesToRun);
//        }
//        return storiesToRun;
//    }


    }


