package HelpDesk.Model;

import java.util.Random;

import HelpDesk.Controller.HelpDeskController;

public class Request {
   public String randId, userName, userRollNum, userBranch, userSem, requestTitle, requestDescription, userEmail;
   public int userBatch;
   public Request(String userName, String userRollNum, String userBranch, String userSem, String requestTitle, String requestDescription, String userEmail, int userBatch) {
    this.userName = userName;
    this.userRollNum = userRollNum;
    this.userBranch = userBranch;
    this.userSem = userSem;
    this.requestTitle = requestTitle;
    this.requestDescription = requestDescription;
    this.userBatch = userBatch;
    this.userEmail = userEmail;
    generateId();
   }

   public Request(String randId, String userName, String userRollNum, String userBranch, String userSem, String requestTitle, String requestDescription, String userEmail, int userBatch) {
      this.randId = randId;
      this.userName = userName;
      this.userRollNum = userRollNum;
      this.userBranch = userBranch;
      this.userSem = userSem;
      this.requestTitle = requestTitle;
      this.requestDescription = requestDescription;
      this.userBatch = userBatch;
      this.userEmail = userEmail;
     }

   private void generateId() {
      String[] randIds = new String[1000];
      int n = HelpDeskController.helpDeskController.getIDList(randIds);
      Random random = new Random();
      Boolean b = false;
      do{
         randId = String.valueOf(random.nextInt(9000)+1000);
         for(int i = 0; i < n; i++) {
            if(randId.equals(randIds[i])) {
               b = true;
               break;
            }
         }
      }while(b);
   }
}
