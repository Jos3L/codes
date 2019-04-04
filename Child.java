public class Child{
   public static final int MIN_AGE = 9;
   public static final int MAX_AGE = 16;
   public static final int MAX_CHILDREN = 17;
   public static final int BASE_RATE = 79;
   public static final int TRANSPORTATION_FEE = 23;
   public static final int MIN_COURSES = 1;
   public static final int MAX_COURSES = 6;
   public static final String [] LOCATIONS = {"Fairfax","Front Royal","Manasas","Loudoun","Arlington","Washington, DC"};
   
   private String name;
   private int age;
   private String parentName;
   private String phone;
   private String districtCode;
   private String courseLocation;
   private int takeCourse;
   private String isScholarship;
   private static int numChildren;
   
   public Child(){
   
   }
   
   public Child (String name, int age, String parentName, String phone){
      if(name == null || name.equals("")){
         throw new IllegalArgumentException("You must provide a name");
      }
      if(age < MIN_AGE || age > MAX_AGE){
         throw new IllegalArgumentException("Child age must be between"+MIN_AGE+" and "+MAX_AGE);
      }
      if(parentName == null || parentName.equals("")){
         throw new IllegalArgumentException("Parent's name is required"); 
      }
      if(!validPhone(phone)){
         throw new IllegalArgumentException("The format of a valid phone number is: 123.444.5555 ");
      } 
      this.name = name;
      this.age= age;
      this.parentName = parentName;
      this.phone = phone;
      ++numChildren;    
   }
   /*
   public Child(String name, int age, String parentName, String phone, String districtCode){
      this(name, age, parentName, phone);
      if(!validDistricCode(districtCode)){
         throw new IllegalArgumentException(
         "The format of school district code is: XYX \n(Where x is a number and y is an uppercase letter)");
      } 
      this.districtCode = districtCode;      
   }*/
   public String getName() {return this.name;}
   public int getAge() {return this.age;}
   public String getParentName() {return this.parentName;}
   public String getPhone() {return this.phone;}
   public String getDistrictCode() {return this.districtCode;}
   public String getCourseLocation() {return this.courseLocation;}
   public int getTakeCourse() {return this.takeCourse;}
   public String getIsScholarship() {return this.isScholarship;}
   public static int getNumChildren() {return numChildren;}
   
   public void setName(String name){
      if(name == null || name.equals("")){
         throw new IllegalArgumentException("You must provide a name");
      }
      this.name = name;      
   }
   public void setAge(int age){
      if(age < MIN_AGE || age > MAX_AGE){
         throw new IllegalArgumentException("Child age must be between "+MIN_AGE+" and "+MAX_AGE);
      }
      this.age = age;   
   }
   public void setParentName(String parentName){
      if(parentName == null || parentName.equals("")){
         throw new IllegalArgumentException("Parent's name is required"); 
      }
      this.parentName = parentName;   
   }
   public void setPhone(String phone){
      if(!validPhone(phone)){
         throw new IllegalArgumentException("The format of a valid phone number is: 123.444.5555 ");
      } 
      this.phone = phone;   
   }
   public void setDistrictCode(String districtCode){
      if(!validPhone(phone)){
         throw new IllegalArgumentException("The format of a valid phone number is: 123.444.5555 ");
      } 
      this.districtCode = districtCode;   
   }
   
	public static String getLocation() {
		String location = "";
		for (int x = 0; x < LOCATIONS.length; x++) {
			location += LOCATIONS[x];
         if (x < LOCATIONS.length - 1) {
            location += ", ";
         }         
      }
		return location;
	}   
   
   public void setCourseLocation(String courseLocation){
      if(!validLocation(courseLocation)){
         throw new IllegalArgumentException(
            "One of the following locations of the list must be specified: " + this.getLocation()); 
      }
      this.courseLocation = courseLocation; 
   }
   
   private boolean validLocation(String courseLocation) {
      boolean locationFound = false;
      int x = 0;
      //this searchs and compares if the user enters the correct order status 
      while (!locationFound && x < LOCATIONS.length) {
         if (LOCATIONS[x].equals(courseLocation)) {
            locationFound = true;
         }
         else {
            ++x;
         }
      }   
      return locationFound;
   }        
   
   public void setTakeCourse(int takeCourse){
      if(takeCourse < MIN_COURSES || takeCourse > MAX_COURSES){
         throw new IllegalArgumentException("A child can take only "+MIN_COURSES+" and "+MAX_COURSES+" courses.");
      }
      this.takeCourse = takeCourse;
   }
   
   public void setIsScholarship(String isScholarship){
      if(isScholarship.equals("") || (!isScholarship.equalsIgnoreCase("Yes") && !isScholarship.equalsIgnoreCase("No"))){
         throw new IllegalArgumentException("You must provide if the child obtains a scholarship (Yes or NO)");
      }
      this.isScholarship = isScholarship;  
   }
   
   public boolean validPhone(String districtCode){
      boolean validCode = true;
      //I add more code later
      return validCode;
   }
   public boolean validDistricCode(String phone){
      boolean validPhoneNum = true;
      //I add more code later
      return validPhoneNum;
   }   
}