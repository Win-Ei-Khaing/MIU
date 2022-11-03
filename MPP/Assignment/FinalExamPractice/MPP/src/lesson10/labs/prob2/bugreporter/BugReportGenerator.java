package lesson10.labs.prob2.bugreporter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Stream;

import lesson10.labs.prob2.classfinder.ClassFinder;

/**
 * This class scans the package lesson10.labs.prob2.javapackage for classes with
 * annotation @BugReport. It then generates a bug report bugreport.txt,
 * formatted like this:
 * 
 * Joe Smith reportedBy: classname: description: severity:
 * 
 * reportedBy: classname: description: severity:
 * 
 * Tom Jones reportedBy: classname: description: severity:
 * 
 * reportedBy: classname: description: severity:
 * 
 *
 */
public class BugReportGenerator {
	private static final Logger LOG = Logger.getLogger(BugReportGenerator.class
			.getName());
	private static final String PACKAGE_TO_SCAN = "lesson10.labs.prob2.javapackage";
	private static final String REPORT_NAME = "bug_report.txt";
	private static final String REPORTED_BY = "reportedBy: ";
	private static final String CLASS_NAME = "classname: ";
	private static final String DESCRIPTION = "description: ";
	private static final String SEVERITY = "severity: ";

	public void reportGenerator() {
		List<Class<?>> classes = ClassFinder.find(PACKAGE_TO_SCAN);
		// implement
		
		HashMap<String,List<String>>developersBugs= new HashMap<String,List<String>>();
		classes.forEach(cl -> {
			Stream.of(cl.getAnnotationsByType(BugReport.class))
					.flatMap(bugs -> Stream.of(bugs))
					.forEach(
							bug -> {
								List<String> bugs=null;
								if(developersBugs.containsKey(bug.assignedTo()))
								{
									bugs= developersBugs.get(bug.assignedTo());
								}else
								{
									bugs= new ArrayList<String>();
									developersBugs.put(bug.assignedTo(), bugs);
								}
								
								StringBuilder stringBuilder = new StringBuilder();

								stringBuilder.append('\t');
								stringBuilder.append(REPORTED_BY);
								stringBuilder.append(bug.reportedBy());
								stringBuilder.append(System
										.getProperty("line.separator"));

								stringBuilder.append('\t');
								stringBuilder.append(CLASS_NAME);
								stringBuilder.append(cl.getName());
								stringBuilder.append(System
										.getProperty("line.separator"));

								stringBuilder.append('\t');
								stringBuilder.append(DESCRIPTION);
								stringBuilder.append(bug.description());
								stringBuilder.append(System
										.getProperty("line.separator"));

								stringBuilder.append('\t');
								stringBuilder.append(SEVERITY);
								stringBuilder.append(bug.severity());
								stringBuilder.append(System
										.getProperty("line.separator"));
								
								bugs.add(stringBuilder.toString());

							});

		});
		
		
		assembleReport(developersBugs);
	}

	public void assembleReport(HashMap<String,List<String>>developersBugs)
	{
		StringBuilder stringBuilder = new StringBuilder();
		
		developersBugs.forEach((developer,bugs)->{
			stringBuilder.append(developer);

			stringBuilder.append(System
					.getProperty("line.separator"));
			bugs.forEach(bug->{
				stringBuilder.append(bug);	

				stringBuilder.append(System
						.getProperty("line.separator"));
			});
		});
		
		System.out.println(stringBuilder.toString());
		writeFile(REPORT_NAME, stringBuilder.toString());
	}
	
	public void writeFile(String reportName, String content) {
		try {

			File file = new File(reportName);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
