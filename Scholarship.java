public class Scholarship extends Child {
   public static final int MIN = 0;
   private String organizationName;
   private double discount;
   private int numEnrolledChildren;
   
   public Scholarship(){
   
   }
   
   public Scholarship(String name, int age, String parentName, String phone, String organizationName, double discount){
      super(name, age, parentName, phone);
      if(organizationName == null || organizationName.equals("")){
         throw new IllegalArgumentException("The name of the organization must be provided");
      }
      if(discount < MIN){
         throw new IllegalArgumentException("The percentage discount must be provided"); 
      }
      this.organizationName = organizationName;
      this.discount = discount;
      ++numEnrolledChildren;
   }
   public String getOrganizationName() {return this.organizationName;}
   public double getDiscount() {return this.discount;}
   public int getNumEnrolledChildren() {return this.numEnrolledChildren;}
   
   public void setOrganizationName(String organizationName){
      if(organizationName == null || organizationName.equals("")){
         throw new IllegalArgumentException("The name of the organization must be provided");
      }
      this.organizationName = organizationName;
   }
   
   public void setDiscount(){
      if(discount < MIN){
         throw new IllegalArgumentException("The percentage discount must be provided"); 
      }
      this.discount = discount;
   }
}