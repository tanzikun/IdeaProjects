package util;


import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class EnterInAccUtil {
	/**
	 * 
	 * @param value
	 * @param type 1-字符 2-无符号数字 3-有符号数字 4-中文字符混合
	 * @param length
	 * @return
	 */
	public static String feildFormat(String value,String type,String length,String decimalDigits){
		if("1".equals(type)){
			return feildFormat4Str(value,Integer.parseInt(length));
		}else if("2".equals(type)){
			return feildFormat4UnsignNum(value,Integer.parseInt(length));
		}else if("3".equals(type)){
			return feildFormat4signNum(value,Integer.parseInt(length),Integer.parseInt(decimalDigits));
		}else if("4".equals(type)){
			return feildFormat4China(value,Integer.parseInt(length));
		}
		return "";
	}
	/**
	 * 中文,需要留两个空格
	 * @param value
	 * @param length
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public static String feildFormat4China(String value,int length){
		int realLen;
		try {
			realLen = value.getBytes("GBK").length;
			int expectLen = length-2;
			if(realLen> expectLen){
				value = value.substring(0,(expectLen-2)/2);
			}else if(realLen < expectLen){
				value = value + createBlank(expectLen-realLen);
			}
			value = value+createBlank(2);
		} catch (UnsupportedEncodingException e) {
			//Trace.logError(Trace.COMPONENT_ACTION, "不支持GBK编码格式");
		}
	
		return value;
	}
	public static void main(String[] args) throws UnsupportedEncodingException{
//		String s = "DGDBTXINP 0000 000 000 00000000000000006225552130002321    20140818 0000000000156+000000000.03773389                        00000 2006ttt                                      000 000000000                8509     000000       000000000            507692201111                                                           00000000000                                                            00 00000000000        0000 +0000000000.00+00000.00+0.00+00000.00+0.00 0000+00000.00+0.00 0000 0000 0000 0000 +0000000000.00                                                                                                                                ";
//		System.out.println(s.getBytes("GBK").length);
		System.out.println(feildFormat4signNum("0",8,7));
	}
	/**
	 * 字符串CHAR  左对齐，右补空格
	 * @param value
	 * @param length
	 * @return
	 */
	public static String feildFormat4Str(String value,int expectLen){
		int realLen  = value.length();
		if(realLen> expectLen){
			value = value.substring(0,expectLen);
		}else if(realLen < expectLen){
			value = value + createBlank(expectLen-realLen);
		}
		return value;
	}
	/**
	 * 无符号数字 ZONED  第一位补空格  右对齐，左补0
	 * @param value
	 * @param length
	 * @return
	 */
	public static String feildFormat4UnsignNum(String value,int expectLen){
		int realLen  = value.length();
		value = value.replace(".", "");
		if(realLen>=expectLen){
			value = createBlank(1)+value.substring(0,expectLen);
		}else if(realLen < expectLen){
			value =  createBlank(1)+createZero(expectLen-realLen)+value;
		}
		return value;
	}
	/**
	 * 无符号数字  左对齐，右补0
	 * @param value
	 * @param length
	 * @return
	 */
	public static String feildFormat4UnsignNumRight(String value,int expectLen){
		int realLen  = value.length();
		value = value.replace(".", "");
		if(realLen>=expectLen){
			value = value.substring(0,expectLen);
		}else if(realLen < expectLen){
			value =  value+createZero(expectLen-realLen);
		}
		return value;
	}
	/**
	 * 无符号数字  右对齐，左补0
	 * @param value
	 * @param length
	 * @return
	 */
	public static String feildFormat4UnsignNumLeft(String value,int expectLen){
		int realLen  = value.length();
		value = value.replace(".", "");
		if(realLen>=expectLen){
			value = value.substring(0,expectLen);
		}else if(realLen < expectLen){
			value =  createZero(expectLen-realLen)+value;
		}
		return value;
	}
	/**
	 * 带符号数字
	 * @param value 0  0.00
	 * @param length
	 * @param decimalDigits 小数位
	 * @return +23.32   -23.0000
	 */
	public static String feildFormat4signNum(String value,int length,int decimalDigits){
		
		if(length<=decimalDigits){
			return value;
		}
		
		String SIGN_STR = "+";
		String DIGIT_STR = ".";
		int digits = value.indexOf(DIGIT_STR);
		
		/*
		 * 小数部分处理
		 */
		String decimalDigitsPart = digits<0?"":value.substring(digits+1);
		decimalDigitsPart = feildFormat4UnsignNumRight(decimalDigitsPart,decimalDigits);
		/*
		 * 整数部分处理
		 */
		String intPart = digits<0?value:value.substring(0,digits);
		intPart = feildFormat4UnsignNumLeft(intPart,length-decimalDigits);
		
		value = SIGN_STR + intPart + DIGIT_STR + decimalDigitsPart;
		
		return value;
	}
	/**
	 * 生成补0字符串
	 * @param length
	 * @return
	 */
	public static String createZero(int length){
		StringBuffer sb = new StringBuffer(); 
		for(int i = 0;i<length;i++){
			sb.append("0");
		}
		return sb.toString();
	}
	/**
	 * 生成补空格字符串
	 * @param length
	 * @return
	 */
	public static String createBlank(int length){
		StringBuffer sb = new StringBuffer(); 
		for(int i = 0;i<length;i++){
			sb.append(" ");
		}
		return sb.toString();
	}
	/**
	 * 获取系统时间
	 * @param format
	 * @return
	 */
	public static String getSysDate(String format){
		Calendar can = Calendar.getInstance();
		SimpleDateFormat sf = new SimpleDateFormat(format);
		return sf.format(can.getTime());
	}
	/**
	 * 获取交易来源码
	 * @param type 交易流水表中的交易类型pfl_type
	 * @return
	 */
	public static String getSrcCode(String fileId,String type){
		String srcCode = "";
		if("01".equals(fileId)){
			if("18".equals(type)||"05".equals(type)||"09".equals(type)){
				srcCode = "9500";
			}else{
				srcCode = "8500";
			}
		}else if("02".equals(fileId)){
			srcCode = "8509";
		}else if("03".equals(fileId)){
			if("14".equals(type)){
				srcCode= "1020";
			}else{
				srcCode= "8507";
			}
		}else if("04".equals(fileId)){
			srcCode = "8607";
		}else{
			srcCode = "8607";
		}
		return srcCode;
	}
	/**
	 * 获取交易类型
	 * @param fileId 01-信用卡入账 02-对公转信用卡入账 03-信用卡分期入账 04-积分加现金入账05-慈善捐款入账
	 * @param tradeType 
	 * @param type 交易流水表中的交易类型pfl_type
	 * @return
	 */
	public static String getTradeCode(String fileId,String tradeType,String type){
		String tradeCode = "0";
		
		if("01".equals(fileId)){
			if("01".equals(tradeType)){
				tradeCode = "4001";
			}else{
				tradeCode = "4102";
			}
		}else if("02".equals(fileId)){
			tradeCode = "2006";
		}else if("03".equals(fileId)){
			if("14".equals(type)){
				tradeCode= "4001";
			}else{
				tradeCode= "4017";
			}
		}else if("04".equals(fileId)){
			if("8200".equals(tradeType)){
				tradeCode = "2003";
			}else if("8100".equals(tradeType)){
				tradeCode = "2705";
			}else{
				tradeCode = "6140";
			}
		}else{
			if("8200".equals(tradeType)){
				tradeCode = "2003";
			}else if("8100".equals(tradeType)){
				tradeCode = "2705";
			}else{
				tradeCode = "6140";
			}
		}
		
		return tradeCode;
	}
}
