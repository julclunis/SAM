SAM Utility Tool
=================

#Purpose

The purpose of this project is to create a prototype for semantic extracting concepts from text file,
specifically archive  material and finding aids for libraries, archives, and museums. The current 
version 1.0 connects with OpenCalais's Web Service, which is a third party service for text analytics. 
Future version will incorporate different semantic analytics techniques.  


#Development Environment

This project is Java based version JavaSE 1.7 . Built Using Eclipse Java EE IDE for Web Developers. 
Version: Kepler Service Release 1

WindowBuilder was used to create and maintain the GUI. 

	
#What to do 
	
Developer and User need to sign up for an account and apply for a API key from OpenCalais before staring analysis. 
	http://www.opencalais.com/

#Dependencies

	commons-io-2.4		<http://commons.apache.org/proper/commons-io/index.html> 
    Jackson JAX-RS    	<http://wiki.fasterxml.com/JacksonHome>
    Guava Libraries    	<http://code.google.com/p/guava-libraries/
    J-Calais-1.0     	<https://code.google.com/p/j-calais/>
    					Java Docs
    						<http://j-calais.googlecode.com/svn/javadoc/index.html>
    					Code licensed under Apache License 2.0 
    						<http://www.apache.org/licenses/LICENSE-2.0>
    						
    						
#Developer Notes
 	The major challenges and learning experience from developing this application. 
 		Understanding that files are large.
 		Understanding the way to iterate over files
 		Using Java
 		working with a variety of Open Source libraries with Java
 		Using WindowsBuilder a Eclipse extension
 		Using GitHub and Source Control.
 		Producing and saving CSV files. 
 	Working To Learn and Add to the Project 
 		multi-threading
 		mvc design pattern
 		dependency manager for eclipse 
 		testing and test driven development (TDD)
 	
 	


#Development Planning Outline
		updated - 6/7/2015

1.00 - FinalPrepforSam/MajorUIUpgrade. (prototype) - New Official Master 
		With current known bugs. 
			Files saves strangely and needing new naming scheme change. (ETF 1.30)
			GUI Freeze when processing s.(ETF 1.20)
			No logging.
1.10 - includes Major GUI redesign.
		Simpler and intuitive GUI updates
	1.10 - MVC Design Pattern
	1.11 - Go live on new design (look left)
	1.13 - Add Testing For OpenCalais Connection.
			Include a way to report account status with OpenCalais
	1.21 - changes GUI - add more details to options
	1.30 - create access to help features
	
1.20 - Command line interface. (NoGUI interface)
	Beginning to include distributed processing considerations - 
		hadoop, scala, java, Windows Server Nano
		Java based containers for .Net Nano Containers for Deep learning plugable for networks clusters of vms taking advantage of scale up and out befiteds for distrubted stroage and processing environment.  - 
		-attactivated for with powhere shell 
	Multi-threading approach to fix GUI Freeze
		Includes ways for monitoring the process with pop up screen. 
	Comply with new API Server Agreement Terms with OpenCalais (Aug 15)
		5,000 Documents Restrictions. 
	Include Logging Capabilities for large documents sets and document sizes on batch processing
		Understand why batch process quits
	
1.30 - Save files focus better (Importing/Exporting)
		Create better naming conventions for saved files.
		Create ways for importing results into OpenRefine. 
			(include better csv format)
		Create ways for importing results into MongoDB
			(save the JSON callback as .json file.)
		Saves
		
1.40 -includes more control over the content returned. 
		add or remove include social tags as a functional option 
		Extract more content for csv from callback

1.50 - Final 
		Future 
		Include ways to access other services beyond OpenCalais.
		Includes other project such as Weka, and Stanford's NLP Tools to start processing in-house
		Include capabilities  
 	