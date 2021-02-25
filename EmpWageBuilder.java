import java.util.*;

interface IComputeEmpWage {

	public void addCompanyEmpWage (String company , int empRatePerHour, int numOfWorkingDays , int maxHoursPerMonth) ;

	public void computeEmpWage ();

	public int getTotalWage (String company);

}

class CompanyEmpWage2 {

	public final String company ; 
	public final int empRatePerHour; 
	public final int numOfWorkingDays ; 
	public final int maxHoursPerMonth ; 
	public int totalEmpWage ;

	public CompanyEmpWage2 (String company, int empRatePerHour,int numOfWorkingDays , int maxHoursPerMonth) { 
		
		this.company = company ;
		this.empRatePerHour = empRatePerHour ; 
		this.numOfWorkingDays = numOfWorkingDays; 
		this .maxHoursPerMonth = maxHoursPerMonth;
		
		totalEmpWage = 0;

	}

	public void setTotalEmpWage (int totalEmpWage) { 
		
		this.totalEmpWage = totalEmpWage;

	}

	public String toString () {

		return "Total Emp Wage for Company: "  + company + " is: " + totalEmpWage ;

	}	

}

public class EmpWageBuilderUC14  implements IComputeEmpWage {
	
	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;

	private LinkedList<CompanyEmpWage2> companyEmpWagelist; 
	private Map<String,CompanyEmpWage2> companyToEmpWageMap;

	public EmpWageBuilderUC14() { 
		
		companyEmpWagelist = new LinkedList<>(); 
		companyToEmpWageMap = new HashMap<>();

	}

	public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) { 
		
		CompanyEmpWage2 companyEmpWage = new CompanyEmpWage2(company, empRatePerHour, numOfWorkingDays, maxHoursPerMonth);
 
		companyEmpWagelist.add (companyEmpWage); 
	
		companyToEmpWageMap.put(company, companyEmpWage);

	}

	public void computeEmpWage(){

		for (int i = 0; i< companyEmpWagelist.size(); i++) { 
			
			CompanyEmpWage2 companyEmpWage = companyEmpWagelist.get(i);

			companyEmpWage.setTotalEmpWage(this.computeEmpWage(companyEmpWage)); 
			
			System .out.println(companyEmpWage);

		}

	}

	public int getTotalWage(String company) {

		return companyToEmpWageMap.get(company).totalEmpWage;

	}
	
	public int computeEmpWage(CompanyEmpWage2 companyEmpWage){
		
		//variables

		int empHrs = 0, totalEmpHrs = 0, totalWorkingDays = 0;

		//Computation

		while (totalEmpHrs <= companyEmpWage. maxHoursPerMonth && totalWorkingDays <  companyEmpWage. numOfWorkingDays) {
			
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
		
		return totalEmpHrs * companyEmpWage. empRatePerHour;
	
		
	}

	public static void main(String [] args) {

		IComputeEmpWage empWageBuilder = new EmpWageBuilderUC14();

		empWageBuilder.addCompanyEmpWage( "DMart", 20, 2 , 10);

		empWageBuilder.addCompanyEmpWage( "Reliance", 10, 4, 20);

		empWageBuilder.computeEmpWage();
 
	}
	
}
