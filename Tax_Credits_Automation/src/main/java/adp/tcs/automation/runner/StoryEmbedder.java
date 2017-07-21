package adp.tcs.automation.runner;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.context.Context;
import org.jbehave.core.context.ContextView;
import org.jbehave.core.context.JFrameContextView;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.EmbedderControls;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.model.ExamplesTableFactory;
import org.jbehave.core.model.TableTransformers;
import org.jbehave.core.parsers.RegexPrefixCapturingPatternParser;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.ContextOutput;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.FreemarkerViewGenerator;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.ContextStepMonitor;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.ParameterConverters;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
import static org.jbehave.core.reporters.Format.CONSOLE;
import static org.jbehave.core.reporters.Format.HTML_TEMPLATE;
import static org.jbehave.core.reporters.Format.TXT;
import static org.jbehave.core.reporters.Format.XML_TEMPLATE;



/**
 * Created by Thorasa on 7/24/2016.
 */
public class StoryEmbedder extends Embedder {

    private final CrossReference xref = new CrossReference();
    private Context context = new Context();
    private Format contextFormat = new ContextOutput(context);
    private ContextView contextView = new JFrameContextView().sized(450, 125);
    private ContextStepMonitor contextStepMonitor = new ContextStepMonitor(context, contextView, xref.getStepMonitor());

  
   public Configuration configuration() {
    	
        Class<? extends StoryEmbedder> embeddableClass = this.getClass();
        Properties viewResources = new Properties();        
        ParameterConverters parameterConverters = new ParameterConverters();
        ExamplesTableFactory examplesTableFactory = new ExamplesTableFactory(new LocalizedKeywords(),
                new LoadFromClasspath(embeddableClass), parameterConverters, new TableTransformers());
        // add custom converters
        parameterConverters.addConverters(new ParameterConverters.DateConverter(new SimpleDateFormat("yyyy-MM-dd")),
                new ParameterConverters.ExamplesTableConverter(examplesTableFactory));
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
                .useStepPatternParser(new RegexPrefixCapturingPatternParser("%"))
                .useStepMonitor(contextStepMonitor);
    }

    @Override
    public EmbedderControls embedderControls() {
        return new EmbedderControls().doGenerateViewAfterStories(true).doIgnoreFailureInStories(true)
                .doIgnoreFailureInView(true).doVerboseFailures(true).useThreads(1).useStoryTimeoutInSecs(43200);    	
    }

    /**
     * Runs the specified stories per the Steps Classes List argument.
     *
     * @param stories List of Strings consisting of text-based scenarios to be executed.
     * @param stepsClasses List of Steps classes to be used to run the stories specified.
     */
    public void run(List<String> stories, List<String> stepsClasses) {
        try {
            useConfiguration(configuration());
            List<CandidateSteps> candidateSteps = candidateStepsPerClassNames(stepsClasses);
            useCandidateSteps(candidateSteps);
            runStoriesAsPaths(stories);
            System.out.println("The run has completed.");
           // generateReportsView();
        } catch (Exception e) {
            System.out.println("Trouble out on the run! Please address these errors "
                    + "through the reports generated under the 'target' directory"+ e);
        }
    }

    //
    /**
     * Returns a list of CandidateSteps corresponding to the available Steps classes.
     *
     * @param classNames List of base class-names corresponding to the Steps to be returned.
     * @return List of CandidateSteps classes matching the simple class-names provided.
     */
    private List<CandidateSteps> candidateStepsPerClassNames(List<String> classNames) {
        List<Object> objectList = getCandidateStepsAsObjects(classNames);
        return new InstanceStepsFactory(configuration(), objectList).createCandidateSteps();
    }

    /**
     * Provides a list of Strings identifying ClassNames, where each String represents a JBehave Steps class
     * Return value: A List of Objects generated per the ClassNames specified in the argument.
     *
     * @param classNames list of names of classes - as Strings - to be converted to instantiated
     *            CandidateSteps objects
     * @return a list of CandidateSteps objects corresponding to the classNames provided as the argument.
     */
    protected static List<Object> getCandidateStepsAsObjects(List<String> classNames) {
        List<Object> objectList = new ArrayList<Object>();
        String stepsClassName = null;
        for (String currentName : classNames) {
            try {
                stepsClassName = currentName;
                Class<?> klass = Class.forName("adp.tcs.automation.stepsfiles."+currentName);
                Object object = klass.newInstance();
                objectList.add(object);
            } catch (Exception e) {
                System.out.println("Exception creating an instance of class |" + stepsClassName + "|"+ e);
            }
        }
        return objectList;
    }

    
}
