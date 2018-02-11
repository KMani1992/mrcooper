# mrcooper - gitrepo details storing app


Problem Scenario Summary
=======================
1.Build the system to retrive a specific user's git public repos and store into the local application database.


Technology Stack Used
======================
1.Java & Spring boot (Core)
2.Rest Web services (API)
3.Apache Derby (Storage)
4.Angular 2.0 (Front End - JS FW)
5.Material Design (GUI Components)


Backend
========

Data Flow
---------

[Request] => Controller=> Service => Builder => Assembler => Service=> Controller => {Response Back to Caller as JSON object}

Explanation
-----------
1.Request comes from front end service followed by [fetchAndStoreGitRepo(String userName)] will be called
(End point name is: http://<hostName>/grp/getUserRepo?userName=<repoName>)
2. Service class getAndStoreGitRepoDet(String userName) will be called
3.Followed by below call will be happened
List<GRPDetFetchResponseDTO> grpResDetList = grpRespBuilder.getGitrepoDet(userName);
Get the requested users github public repositry details. These are taken using rest template and
converted into java objects also return back as List<GRPDetFetchResponseDTO>
4.Followed by check if the user record already exists in local DB or else save it
GRPUserDetail grpUserDet = findAndsaveUserDet(userName);
5.Followed by assemple the required properties from the inputs by below statement
grpUsrRepoDetList = grpRespAssembler.assembleUserRpoDet(grpUserDet, grpResDetList);
6.Finally save the user repo details by below method
saveGrpDet(grpUsrRepoDetList);

Highlights
----------
1.Used Composite Key to store the user repo details. it will avoid data duplication based on the userName and repoName
2.Industry Standard Data flow sequence used. using this can edtend the code easily.
3.Componets are seperated so this code can be easily testable and maintainable


To Run the Backend service 
---------------------------
1.Downlloaad the service jar file : 
https://github.com/KMani1992/mrcooper/blob/master/back_end/bin/gitrepodownload-0.0.1-SNAPSHOT.jar
2.Run the jar via terminal by below command
java -jar gitrepodownload-0.0.1-SNAPSHOT.jar
3.Request the below end point in br to save it
(End point name is: http://localhost:8081/grp/getUserRepo?userName=<repoName>)
4.Request the below end point in br to view all the saved repository data
http://localhost:8081/grp/getAllRepo

Front End
=========

Data Flow
---------

Input => component.ts => service.ts => call the rest URL => return back the response to service.ts
=> return back to component.tx => render the response in view

Explanation
-----------
1.Enter the repo name in input text box and hit the store button
2.It will call the storeRepoData() function
3.Followed by below function will be called
 this._service.storeGitRepo(this.repoName)
4.Followed by below method will be called in service
this.http.get(`${this.baseUrl})
5.Followed by response will be sent to called method and response are rendered in view

To Run the Fron End code
------------------------
1.Download the front end code and load it into visual code studio edition
2.Run the code by ng serve command in angular CLI
3.Hit the below URL in browser. application will be opened
localhost:4200



