class CompanyEmpWage {
	
	public final String company; 
	public final int empRatePerHour; 
	public final int numOfWorkingDays;

	public final int maxHoursPerMonth; 
	public int totalEmpWage;

	public CompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) { 
		
		this .company = company ;
		this .empRatePerHour = empRatePerHour; 
		this .numOfWorkingDays = numOfWorkingDays; 
		this .maxHoursPerMonth = maxHoursPerMonth;

	}

	public void setTotalEmpWage (int totalEmpWage) { 
		
		this.totalEmpWage = totalEmpWage ;

	}

	public String toString () {

		return "Total Emp Wag e for Company : " +company+" is: "+ totalEmpWage;

	}
	
}

public class EmpWageBuilderArrayUC10 {

	public static final int IS_PART_TIME = 1; 
	public static final int IS_FULL_TIME = 2;

	private int numOfCompany = 0;
	
	private CompanyEmpWage2[] companyEmpWageArray;

	public EmpWageBuilderArrayUC10() { 
		
		companyEmpWageArray = new CompanyEmpWage2[5];
		
	}

	private void addCompanyEmpWage (String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
			
		companyEmpWageArray[numOfCompany] =  new CompanyEmpWage2(company, empRatePerHour,numOfWorkingDays, maxHoursPerMonth) ;

		numOfCompany++;
		
	}

	private void computeEmpWage (){

		for (int i = 0; i < numOfCompany; i++) {

			companyEmpWageArray[ i].setTotalEmpWage (this.computeEmpWage (companyEmpWageArray [i]) ); 
			
			System.out.println(companyEmpWageArray[i]);
			
		}
		
	}
			
	private int computeEmpWage (CompanyEmpWage2 companyEmpWage2) {

		//variables

		int empHrs = 0, totalEmpHrs = 0, totalWorkingDays = 0;

		//Computation

		while (totalEmpHrs <= companyEmpWage2. maxHoursPerMonth && totalWorkingDays <  companyEmpWage2. numOfWorkingDays) {
			
			totalWorkingDays++;

			int empCheck = (int) Math.floor(Math.random ()* 10) % 3;

			switch (empCheck) { case IS_PART_TIME:

				empHrs = 4;
				break;

			case IS_FULL_TIME:

				empHrs = 8; 
				break;

			default:

				empHrs = 0;
			
			}
			
			totalEmpHrs += empHrs ;

			System.out.println ("Day: " + totalWorkingDays + " Emp Hr: " + empHrs) ;
			
		}
		
		return totalEmpHrs * companyEmpWage2. empRatePerHour;
	
	}
	
	public static void main (String[] args) {

		EmpWageBuilderArrayUC10  empWageBuilder =  new EmpWageBuilderArrayUC10( );
		
		empWageBuilder. addCompanyEmpWage ("DMart ", 20, 2, 10);

		empWageBuilder. addCompanyEmpWage ("Reliance", 10, 4, 20); 
		
		empWageBuilder. computeEmpWage ();	

	}
	
}
