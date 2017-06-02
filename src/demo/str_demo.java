package demo;

public class str_demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		 String absoluteResultPath = "s3://pub-collector/ECPM_REVENUE_RESULT/" ; //+resultPath;  //创建表的时候会指定查询结果存放的目的地址
//	        String source_S3Path="s3://pub-collector/pubreport/publish/" ;//后面按年,月,日,小时分区
//	        // 判定链接S3的数据是否链接成功,并设定返回的查询文件路径
//	     
//	        StringBuffer strBuf = new StringBuffer();
//	        strBuf.append("CREATE EXTERNAL TABLE IF NOT EXISTS ECPM_REVENUE");
//	        strBuf.append("(");
//	        strBuf.append("day                       STRING ,");
//	        strBuf.append("publisher_id               STRING ,");
//	        strBuf.append("publisher_name               STRING ,");
//	        strBuf.append("advertiser_id                STRING ,");
//	        strBuf.append("site_id                     STRING ,");
//	        strBuf.append("placement_id                 STRING ,");
//	        strBuf.append("placement_name               STRING ,");
//	        strBuf.append("site_name                 STRING ,");
//	        strBuf.append("imp_type               STRING ,");
//	        strBuf.append("size              STRING,");
//	        strBuf.append("imps                BIGINT,");
//	        strBuf.append("total_network_rpm          double ,");
//	        strBuf.append("revenue                    double,");
//	        strBuf.append("supply_type                 STRING");
//	        strBuf.append(") PARTITIONED BY (year STRING,month STRING,dat STRING,hour STRING)");  //按年,月,日,小时分区
//	        strBuf.append(" ROW FORMAT DELIMITED FIELDS TERMINATED BY '\\t' ");
//	        strBuf.append(" LOCATION '" +source_S3Path  + "' tblproperties (\"skip.header.line.count\"=\"1\") ");//去掉第一行的头
//		
//		   System.out.printf(strBuf.toString());
//	      String  dat="2017-04-10-05";
//		
//		 String resultpath_="year="+dat.substring(0,4)+"/"+"month="+dat.substring(5,7)+"/"+"dat="+dat.substring(8,10)+"/";//  +"hour="+dat.substring(11,13)+"/";
////	        String resultpath=resultpath_+dat; //分区到天,传入的为小时,而后删除即可
////	        //指标的结果显示在路径的名称里,每个指标的计算结果应该保证其dt的增量计算的唯一性,因此字段里应该有dt的按天算的增量时间+最近一次调度的时间(时间参数化,
////	        //路径应该是 指标名称/文件名+最小粒度的时间
////	        String absoluteResultPath = "s3://pub-collector/queryresult_athena/" + "ECPM_REVENUE_RESULT"+"/"+resultpath;
////	        System.out.printf(absoluteResultPath.toString());
//		   String dat="2017-04-10-05";
//		   String resultpath_="year="+dat.substring(0,4)+"/"+"month="+dat.substring(5,7)+"/"+"dat="+dat.substring(8,10)+"/";//  +"hour="+dat.substring(11,13)+"/";
//	        String resultpath=resultpath_+dat; //分区到天,传入的为小时,而后删除即可
//	        //指标的结果显示在路径的名称里,每个指标的计算结果应该保证其dt的增量计算的唯一性,因此字段里应该有dt的按天算的增量时间+最近一次调度的时间(时间参数化,
//	        //路径应该是 指标名称/文件名+最小粒度的时间
//	        String absoluteResultPath = "s3://pub-collector/queryresult_athena/" + "ECPM_REVENUE_RESULT"+"/"+resultpath;
//	        System.out.printf(absoluteResultPath.toString());
		
	    final double floorPrice=0.50;  // 设置floorprice,后期放表里参数化
	     final double DefaultRevenueShare=0.50; //根据系统手动设置,默认0.5
	     final double PlatformShare=0.25;  //根据系统手动设置,默认0.25
		String dt="2017-04-10-05";
	     StringBuffer strBuf_ecpm_Resold = new StringBuffer();
		 strBuf_ecpm_Resold.append(
	                "select day, publisher_id,publisher_name,advertiser_id,site_id,placement_id, placement_name,site_name,imp_type, size,imps,total_network_rpm,revenue,supply_type,");
	        strBuf_ecpm_Resold.append(" （total_network_rpm - "+ floorPrice+" " );
	        strBuf_ecpm_Resold.append( " - "+PlatformShare+ " * "+  floorPrice+")* "+ DefaultRevenueShare+" as Revenue_share ");
	        strBuf_ecpm_Resold.append(" from ECPM_REVENUE where year='"
	                + dt.substring(0,4) + "' and month= '"+dt.substring(5,7)+"' and dat='"+dt.substring(8,10)+"' and hour= '"+dt.substring(11,13)+"' and  imp_type='Resold' ");
	       // strBuf_ecpm_Kept.append();
		
	        System.out.printf(strBuf_ecpm_Resold.toString());
		
		
	}

}
