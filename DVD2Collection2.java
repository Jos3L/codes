import javax.swing.JOptionPane;
// problem

public class DVD2Collection2 {
   public static void main(String[] args) {
      final int MAX_NUM_DVD2S = 100;
      DVD2[] collection = new DVD2[MAX_NUM_DVD2S];
      int position = DVD2.getNumDVD2s();
      
      int menuChoice = getMenuOption();
      while (menuChoice != 5) {
         switch(menuChoice) {
            case 1:
               addDVD2(collection, position);
               break;
               
            case 2:
               printNumDVD2s();
               break;
               
            case 3:
               printDVD2Collection2(collection);
               break;
            
            case 4:
               removeDVD(collection, position);   
               break;
            default:
               // Program should never reach this condition if logic is correct
               throw new RuntimeException("Unknown error in menu choice");
         }
         menuChoice = getMenuOption();
      }
    }
   public static String getList(DVD2[] collection){
      String dvdList = "";
        for (int x = 0; x < DVD2.getNumDVD2s(); x++) {
            if(collection[x] !=null){
            System.out.println("Inside of getList(): "+collection[x]);
            dvdList += "\n" + collection[x].getTitle();
            }
           if(collection[x] !=null){
           if (x < collection.length - 1) {
            dvdList += ", ";
           }
         }         
      }
      return dvdList;
   }   
   
   public static void removeDVD(DVD2[] collection, int position){
      String selectDVD = JOptionPane.showInputDialog("Select any DVD that have been added: \nChose one of the following: "+getList(collection));
      int dvdIndex = -1;
      for(int x=0; x < DVD2.getNumDVD2s(); x++){
         if(collection[x].getTitle().equalsIgnoreCase(selectDVD)){
            dvdIndex = x;
         }
      }
      int nextIndex = dvdIndex +1; //adding + 1 to in
      if(dvdIndex != -1){
         JOptionPane.showMessageDialog(null, dvdIndex);// print index
         collection[dvdIndex] = null; // delete on dvdIndex position  
         
         if(nextIndex < collection.length) { //verifying is not the last index 
         do {
         collection[dvdIndex] = collection[nextIndex];
         dvdIndex++;
         nextIndex++;
         }
         while(nextIndex < collection.length);
      }
      }
      else{
         JOptionPane.showMessageDialog(null,"no orders found");
      }
      System.out.println("THIS IS THE ARRAY: \n"+collection[dvdIndex]);
 
   }
   
   public static int addDVD2(DVD2[] collection, int position) {
      position = DVD2.getNumDVD2s();
      
      if (position < collection.length) {
         try {
            DVD2 oneDvd = new DVD2(
               JOptionPane.showInputDialog("Enter the title of the DVD2"), 
               JOptionPane.showInputDialog("Enter the genre of the DVD2. Options are: " + DVD2.getGenres())
            );
            collection[position] = oneDvd;
         }
         catch(IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "DVD2 could not be added to the collection. " + e.getMessage());
         }
      }
      else {
         JOptionPane.showMessageDialog(null, "The collection is full. No more DVD2s can be added.");
      }
      return position;
   }
   
   public static void printNumDVD2s() {
      JOptionPane.showMessageDialog(null, "Number of DVD2s in Collection: " + DVD2.getNumDVD2s());
   }
   
   public static void printDVD2Collection2(DVD2[] collection) {
      String output = "";
      
      for (int x = 0; x < DVD2.getNumDVD2s(); x++) {
         if(collection[x] != null){
         System.out.println("Inside of printDvDCollection2: "+collection[x]);
         output += collection[x].toString() + "\n";
        }
      }
      
      JOptionPane.showMessageDialog(null, output);
   }
   
   public static int getMenuOption() {
      int menuChoice;
      
      do {
         try {
            menuChoice = Integer.parseInt(JOptionPane.showInputDialog(
               "Enter your selection:"
               + "\n(1) Add DVD2"
               + "\n(2) Print Number of DVD2s in Collection"
               + "\n(3) Print DVD2 Collection"
               + "\n(4) Remove DVD"
               + "\n(5) Exit Program"
            ));
         }
         catch (NumberFormatException e) {
            menuChoice = 0;
         }
         if (menuChoice < 1 || menuChoice > 5) {
            JOptionPane.showMessageDialog(null, "Invalid choice. Please enter a valid menu option.");
         }
      } while (menuChoice < 1 || menuChoice > 5);
      
      return menuChoice;
   }
}


