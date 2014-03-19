/**
 * 
 */
package com.css.crm.utility;

/**
 * Define all constant for whole application
 * 
 * @author AIS
 */
public class ConstantUtil {

	/**
	 * application id
	 */
	public static final String APPLICATION_ID = "CRM1";
	
	/**
	 * URL navigation constant
	 */
	public static final String LOGIN_PASSED = "mainMenu";
	public static final String LOGIN_FAILED = "login";
	public static final String LOGOUT = "logout";
	
	/**
	 * date display format
	 */
	public static final String DATE_FORMAT_COMMON = "yyyy-MM-dd";
	public static final String DATE_FORMAT_COMMON_YMDSM = "yyyy-MM-dd hh:mm";
	/**
	 * menu type
	 */
	public static final String MENU_ROOT = "RTMU";
	public static final String MENU_ITEM = "MENU";
	public static final String MENU_FUNC = "FUNC";
	
	/**
	 * parameter name of function id for each menu
	 */
	public static final String PARAM_FUNC_ID = "funcId";
	
	/**
	 * communication type code Home/Office/Contact
	 */
	public static final String COMMUNICATE_TYPE_HOME = "H";
	public static final String COMMUNICATE_TYPE_OFFICE = "O";
	public static final String COMMUNICATE_TYPE_CONTACT = "C";
	
	/**
	 * solr query configs
	 */
	public static final String SOLR_SERVER_URL = "solr_server_patch";
	public static final String SOLR_QUERY_RECORD_LIMIT = "record_max_limit";
	public static final String SOLR_QUERY_DISTRIB = "distrib";
	public static final String SOLR_MATCH_RECORD_LIMIT = "match_record_limit";
	
	/**
	 * default year of birthday
	 */
	public static final String DEFAULT_YEAR_DOB = "1904";
	
	/**
	 * default table rows display for one page
	 */
	public static final String SYSTEM_TABLE_ROWS = "table_rows_display";
	
	/**
	 * modify type (update/delete)
	 */
	public static final String DML_CDE_UPDATE = "U";
	public static final String DML_CDE_DELETE = "D";
	
	/**
	 * static reference type
	 */
	public static final String SALUTE_REF_TYPE = "TITLE";
	public static final String FR_CHANL_REF_TYPE = "CC";
	public static final String SERVICE_REF_TYPE = "CRM_EVENT";
	public static final String ATTRIBUTE_REF_TYPE = "OPT_IN_OUT";
	
	/**
	 * static reference code
	 */
	public static final String ATTRIBUTE_REF_CODE = "POST331";
	
	/**
	 * place type
	 */
	public static final String PLACE_TYPE_PRVNC = "CRM_PRVNC";
	public static final String PLACE_TYPE_CITY = "CRM_CITY";
	
	/**
	 * key of session map
	 */
	public static final String SESSION_USER_KEY = "user";
	public static final String SESSION_USER_MANAGER_KEY = "userManager";
	public static final String SESSION_MENU_KEY = "menuBean";
	public static final String SESSION_PERMISSION_KEY = "permissionCollection";
	
	/**
	 * login page navigation
	 */
	public static final String PAGE_LOGIN = "login";
	
	/**
	 * customer status code valid/cancelled
	 */
	public static final String CUSTOMER_STAT_CODE_C = "C";
	public static final String CUSTOMER_STAT_CODE_V = "V";
	
	/**
	 * customer mbr class
	 */
	public static final String CUSTOMER_MBR_CLASS_I = "I";
	public static final String CUSTOMER_MBR_CLASS_V = "V";
	
	/**
	 * common value of yes/no
	 */
	public static final String COMMON_YES = "Y";
	public static final String COMMON_NO = "N";
	
	/**
	 * customer sex code male/famale
	 */
	public static final String CUSTOMER_SEX_MALE = "M";
	public static final String CUSTOMER_SEX_FEMALE = "F";
	
	/**
	 * customer title code Mr.
	 */
	public static final String CUSTOMER_TITLE_MR = "01";
	public static final String CUSTOMER_TITLE_NA = "00";
	/**
	 * database exception code for return multiply records when single required
	 */
	public static final String DB_EXCEPTION_CODE_0001 = "e0001";
	/**
	 * customer page tab id
	 */
	public static final String TAB_BASIC_INFO = "formId:customerBasicInfoTabId";
	public static final String TAB_ATTRIBUTE = "formId:customerAttributeTabId";
	public static final String TAB_DISCOUNT = "formId:customerDiscountTabId";
	public static final String TAB_MEMBERSHIP = "formId:customerMembershipTabId";
	public static final String TAB_TRANSACTION = "formId:customerTransactionTabId";
	public static final String TAB_SERV_EVENT = "formId:customerServiceEventTabId";
	public static final String TAB_AUDIT_TRAIL = "formId:customerAuditTrailTabId";
}
