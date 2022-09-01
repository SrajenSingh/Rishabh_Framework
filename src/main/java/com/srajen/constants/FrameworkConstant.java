package com.srajen.constants;

public final class FrameworkConstant {
    private FrameworkConstant(){

    }
 /*   private static  String REPORT_PATH = System.getProperty("user.dir")+"/index.html";
*/
    private static String REPORT_PATH;
    public static String getReportPath(){
        return REPORT_PATH;
    }
   public static String setReportPath(String className){
        REPORT_PATH= System.getProperty("user.dir")+"/"+className+".html";
        return REPORT_PATH;
    }

}
