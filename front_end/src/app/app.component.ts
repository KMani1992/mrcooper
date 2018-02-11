import { Component } from '@angular/core';
import * as globalSym from './globalSymbol'
import {GitService} from './git.service'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Store GitHub Repository\'s Metadata';
  repoName = '';
  errorMessage='';
  infoMessage='';
  viewAllRepoURL=`${globalSym.baseURL}/grp/getAllRepo`;
  gitRepoStoreRes:any={};

  constructor(private _service:GitService){

  }
 
 storeRepoData()
 {
   if(""!=this.repoName){
    
    this.clearMsg();
    this.infoMessage="Progressing, Please Wait...";
    this._service.storeGitRepo(this.repoName)
          .then(gitRepoStoreRes => {
            this.gitRepoStoreRes = gitRepoStoreRes;
            this.clearMsg()
            if(this.gitRepoStoreRes.statusCode=="-1"){
              this.errorMessage=this.gitRepoStoreRes.statusMsg;
            }
            else{
              this.infoMessage=this.gitRepoStoreRes.statusMsg;
            }
          },
          error => this.errorMessage=<any>error);
   }
   else
   {
     this.errorMessage="Please Enter Repo Name";
   }
}

clearMsg(){
  this.infoMessage='';
  this.errorMessage='';
}
}
