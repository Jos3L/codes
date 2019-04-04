import javax.swing.JOptionPane;
public class ChildrenCourses{
   public static void main (String [] args){
      
      final int MAX_CHILDREN = 17;
      Child[] allChildren = new Child[MAX_CHILDREN];
      Scholarship[] addInfoChildren= new Scholarship[allChildren.length]; 
   
      int menuChoice = getMenu();
      while (menuChoice != 5){
         switch(menuChoice){
            case 1:
               addChild(allChildren);
               break;
            case 2:
               enrollChild(allChildren, addInfoChildren, Child.getNumChildren());
               break;
            case 3:
               //removeEnrolledChild(allChildren, Child.getNumChildren());
               break;
            case 4:
               //printChildRecord(allChildren, Child.getNumChildren());
               break;
               
            default:
               throw new RuntimeException("Unknown error in the menu");
         } 
         menuChoice = getMenu(); 
      }
      JOptionPane.showMessageDialog(null, "Thank you for using this program!");
   }
   
   public static String getList(Child[] allChildren){
      String childrenList = "";
		for (int x = 0; x < Child.getNumChildren(); x++) {
			childrenList += "\n" + allChildren[x].getName();
         if (x < allChildren.length - 1) {
            childrenList += ", ";
         }         
      }
      return childrenList;
   }
   
   public static void enrollChild(Child[] allChildren, Scholarship[] addInfoChildren, int numChildren){
      String selectChild = JOptionPane.showInputDialog("Select any child that have been added: \nChose one of the following: "+getList(allChildren));
      int childIndex = -1;
      for(int x=0; x < Child.getNumChildren(); x++){
         if(allChildren[x].getName().equalsIgnoreCase(selectChild)){
            childIndex = x;
         }
      }
      if(childIndex != -1){
         JOptionPane.showMessageDialog(null, childIndex);
         Child scholar = new Scholarship(name, age, parentName, phone
                         //JOptionPane.showInputDialog("Enter the organization name: "),
                         //JOptionPane.showInputDialog("Enter the discount for the child: ")
                         );
      } else{
         JOptionPane.showMessageDialog(null,"no orders found");
      }
  } 
   
   public static void addChild(Child[] allChildren){
      int currentSize = Child.getNumChildren();
      //This verifies that the user do not pass the maximum space of the array of objects
      if(currentSize < allChildren.length){
      //Once an child is created, ensures..... is added.
      //Exceptions are handled here to ask the user to enter the correct value.      
         boolean childSet = false;
         do{
            try{
               Child oneChild = new Child (
                  JOptionPane.showInputDialog("Enter the name of the child: "),
                  Integer.parseInt(JOptionPane.showInputDialog("Enter the age of the child: ")),
                  JOptionPane.showInputDialog("Enter the parent's name of the child: "),
                  JOptionPane.showInputDialog("Enter the parent's cell phone of the child: "));
                  childSet = true;
               allChildren[currentSize] = oneChild;
            }
            catch (NumberFormatException e) {
               JOptionPane.showMessageDialog(null, "You did not enter a number. Please try again");
            }         
            catch(IllegalArgumentException e){
               JOptionPane.showMessageDialog(null, "Child could not be added to the list. "+ e.getMessage());
            }         
          }while(!childSet);
          
          boolean districtCodeSet = false;
          do{
            try{
               allChildren[currentSize].setDistrictCode(JOptionPane.showInputDialog("Enter the school district code: "));
               districtCodeSet = true;
            }
            catch(IllegalArgumentException e){
               JOptionPane.showMessageDialog(null, "The district code could not be set. " + e.getMessage());
            }
          }while(!districtCodeSet);
          
         //Once a Child is created, ensure a correct course location is added.
         //Exceptions are handled here to ask the user to enter the correct value.       
         boolean locationSet = false;
         do {
            try {
               allChildren[currentSize].setCourseLocation(JOptionPane.showInputDialog("What is the course location? "+
                  "\n Please provide one of the following locations: " + Child.getLocation() 
               ));
               locationSet = true;
            }
            catch(IllegalArgumentException e) {
               JOptionPane.showMessageDialog(null, "The location of the course could not be set. " + e.getMessage());
            }
         } while(!locationSet); 
         //Once an Child is created, ensure a valid course to take is added.
         //Exceptions are handled here to ask the user to enter the correct value.        
         boolean takeCourseSet = false;
         do {
            try {
               allChildren[currentSize].setTakeCourse(Integer.parseInt(JOptionPane.showInputDialog("Enter the courses of the child: "+
                  "\nCourses must be between "+Child.MIN_COURSES+" and "+Child.MAX_COURSES
               )));
               takeCourseSet = true;
            }
            catch (NumberFormatException e) {
               JOptionPane.showMessageDialog(null, "You did not enter a number. Please try again");
            }
            catch (IllegalArgumentException e) {
               JOptionPane.showMessageDialog(null, e.getMessage());
            }
         }while (!takeCourseSet);  
         
         boolean scholarshipSet = false;
         do{
            try{
               allChildren[currentSize].setIsScholarship(JOptionPane.showInputDialog("Enter if the child obtained a scholarship: "));       
               scholarshipSet = true;
            }
            catch(IllegalArgumentException e) {
               JOptionPane.showMessageDialog(null, "The scholarship of the child could not be set. " + e.getMessage());
            }
         }while(!scholarshipSet);                    
      }
      else{
         JOptionPane.showMessageDialog(null, "There is no more room for additional child!");   
      }          
   }
     
   public static int getMenu() {
      int menuChoice;
      do{
         try{
            menuChoice = Integer.parseInt(JOptionPane.showInputDialog(
               "Enter one number of this selection:" +
               "\n 1) Add Child" +
               "\n 2) Enroll Child" + 
               "\n 3) Remove Enrolled Child" + 
               "\n 4) Print Child Record" + 
               "\n 5) Quit"            
            ));
         }
         catch(NumberFormatException e){
            menuChoice = 0;
         }
         if(menuChoice < 1 || menuChoice > 5){
            JOptionPane.showMessageDialog(null, "Please enter a valid menu choice selection");
         }
      }while(menuChoice < 1 || menuChoice > 5);
      
      return menuChoice;   
   }
}   