package com.candidates.util;
/**
* @author riddhi.dilip.vyas
* @date 10/17/2018
*
* @group Accounts
* @group-content 
*
* @description: QueryConstants contains all the queries and column names  
*/
public class QueryConstants {

	public static final String GET_CONDITIONS = "select sn.name,sn.tr1__consent_email_body_request__c from salesforce.tr1__consent_type__c as sn where sn.tr1__language__c =? ";
	
	public static final String COLUMN_CONSENT_EMAIL_BODY = "tr1__consent_email_body_request__c";
	
	public static final String COLUMN_CONSENT_NAME = "name";
	
	public static final String CHECK_EMAIL_UNICITY_CONTACT = "select Count(Email) as count from salesforce.Contact where UPPER(Email) = ?";
	
	public static final String CHECK_EMAIL_UNICITY_USER = "select Count(Email) as count from salesforce.User  where UPPER(Email) = ?";
	
	public static final String GET_DATA_HISTORY = "select status,reason from salesforce.case where UPPER(ContactEmail)= ? and reason in ('Portability','Field History') ";
	
	public static final String COLUMN_STATUS = "status";
	
	public static final String COLUMN_REASON = "reason";
	
	public static final String GET_SKILLS = "select sfid,tr1__language__c  from salesforce.contact where Upper(email) = ?";
	
	public static final String COLUMN_LANGUAGE = "tr1__language__c";
	
	public static final String GET_PROFILE = "";
	
	public static final String GET_WORK_EXP = "select eh.sfid,tr1__employername__c,TR1__City__c,tr1__title__c,tr1__description__c,tr1__startdate__c,tr1__enddate__c from salesforce.tr1__employmenthistory__c eh, salesforce.contact cnt where cnt.sfid = eh.tr1__contact__c and UPPER(cnt.email) = ?";
	
	public static final String COLUMN_COMPANY_NAME = "tr1__employername__c";
	
	public static final String COLUMN_COMPANY_LOCATION = "TR1__City__c";
	
	public static final String COLUMN_WORK_EXP_DESC = "tr1__description__c";
	
	public static final String COLUMN_WORK_EXP_TITLE = "tr1__title__c";
	
	public static final String GET_CANDIDATES_EDUCATION = "select eh.sfid,tr1__degreename__c,tr1__degreetype__c,tr1__startdate__c,tr1__enddate__c from salesforce.tr1__educationhistory__c eh, salesforce.contact cnt where cnt.sfid = eh.tr1__contact__c and UPPER(cnt.email) =?";
	
	public static final String COLUMN_QUALIFICATION_NAME = "tr1__degreename__c";
	
	public static final String COLUMN_QUALIFICATION_TYPE = "tr1__degreetype__c";
	
	public static final String COLUMN_START_DATE = "tr1__startdate__c";
	
	public static final String COLUMN_END_DATE = "tr1__enddate__c";
	
	public static final String COLUMN_SF_ID = "sfid";
	
	public static final String COLUMN_NAME = "name";
	
	public static final String GET_OPEN_NOTIFICATIONS = "select count(corecap_status__c) as count from salesforce.CORECaP_Notification__c nf, salesforce.contact cnt where nf.corecap_notificationtype__c='Profile Inactivity' and nf.corecap_contact__c = cnt.sfid and Upper(cnt.email) = ? and  nf.corecap_status__c= 'Open' ";
}
