

Given Insert hire record in DWHNEWHIRE table and execute ETL PLSQL
Given User log in for screening process
Given User perform screening test

Examples:
|scenarioName|storyName| storyDescription|ClientCode | CompanyCode | UnitCode | Gave|Offer|Hire|Start|
|WebIn| PayrollTesting.story| Testing |30412 | 30488 | TX_Unit1 |0|0|0|0|
|WebIn| PayrollTesting.story| Testing |30412 | 30488 | TX_Unit1 |1|0|0|0|
|WebIn| PayrollTesting.story| Testing |30412 | 30488 | TX_Unit1 | null |0|0|0|
|WebIn| PayrollTesting.story| Testing |30412 | 30488 | TX_Unit1 | 0 |null|0|0|
|WebIn_payroll| PayrollTesting.story| Testing |30485 | 30625 | TX_Unit1 | null |0|0|0|
|WebIn_payroll| PayrollTesting.story| Testing |30485 | 30625 | TX_Unit1 | 0 |null|0|0|
|WebIn_payroll| PayrollTesting.story| Testing |30485 | 30625 | TX_Unit1 | 0 |0|0|0|
|WebIn_payroll| PayrollTesting.story| Testing |30485 | 30625 | TX_Unit1 | 1 |0|0|0|
