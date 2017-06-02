package demo;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
public class formdatepath {
	static DateFormat dfmt = new SimpleDateFormat("yyyy-MM-dd-HH");
	  static final double floorPrice=0.50;  // 设置floorprice,后期放表里参数化
	  static final double DefaultRevenueShare=0.50; //根据系统手动设置,默认0.5
	   static final double PlatformShare=0.25;  //根据系统手动设置,默认0.25
	  
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		 String resultPath = dfmt.format(new Date()) + "/";
//		 System.out.printf(resultPath.toString()+"\n");
//		 System.out.printf(resultPath.toString().substring(11,13));
//		String dat="2017-04-10-05";
//		String resultpath="year="+dat.substring(0,4)+"/"+"month="+dat.substring(5,7)+"/"+"dat="+dat.substring(8,10)+"/"+"hour="+dat.substring(11,13)+"/";
//		System.out.println(resultpath.toString());
//		String dt="2017-04-10-05";
//		StringBuffer strBuf_ecpm_Resold = new StringBuffer();
//		strBuf_ecpm_Resold.append(
//             "select day, publisher_id,publisher_name,advertiser_id,site_id,placement_id, placement_name,site_name,imp_type, size,imps,total_network_rpm,revenue,supply_type,");
//
//        strBuf_ecpm_Resold.append(" （total_network_rpm - "+ floorPrice+" " );
//        
//        //("LOCATION ' " +source_S3Path  + "' tblproperties('skip.header.line.count'='1') ");
//       
//        strBuf_ecpm_Resold.append( " - "+PlatformShare+ " * "+  floorPrice+")* "+ DefaultRevenueShare+" as Revenue_share )");
//
//        strBuf_ecpm_Resold.append(" from ECPM_REVENUE where year='"
//                + dt.substring(0,4) + "' and month= '"+dt.substring(5,7)+"' and dat='"+dt.substring(8,10)+"' and hour= '"+dt.substring(11,13)+"' and  imp_type='Resold' ");
//        
//		System.out.println(strBuf_ecpm_Resold.toString());
		//2017-04-10-05
		String dat="2017-04-10-05";
		String resultpath_="year="+dat.substring(0,4)+"/"+"month="+dat.substring(5,7)+"/"+"dat="+dat.substring(8,10)+"/";//  +"hour="+dat.substring(11,13)+"/";
        String resultpath=resultpath_+dat; //分区到天,传入的为小时,而后删除即可
        //指标的结果显示在路径的名称里,每个指标的计算结果应该保证其dt的增量计算的唯一性,因此字段里应该有dt的按天算的增量时间+最近一次调度的时间(时间参数化,
        //路径应该是 指标名称/文件名+最小粒度的时间
        String absoluteResultPath = "s3://pub-collector/queryresult_athena/" + "ECPM_REVENUE_RESULT"+"/"+resultpath;
        String buckname_path="s3://pub-collector/queryresult_athena/" + "ECPM_REVENUE_RESULT"+"/"+resultpath_;
		System.out.printf(absoluteResultPath.toString()+"\n");
		System.out.printf(buckname_path.toString());
		
		
		
		
		
		
		
		
		
		
	}

}
