package com.candidates.dao.impl;
/**
* @author riddhi.dilip.vyas
* @date 10/24/2018
*
* @group Accounts
* @group-content 
*
* @description: CandidatesProfileDaoImpl is a doa impl class which connect to the database and fetches records
* 
* 
*/
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.candidates.dao.CandidatesProfileDao;
import com.candidates.model.CandidateWorkExpResponse;
import com.candidates.model.CandidatesEducationResponse;
import com.candidates.model.CandidatesSkillResponse;
import com.candidates.model.DataHistoryResponse;
import com.candidates.model.DocumentResponse;
import com.candidates.model.Education;
import com.candidates.model.GetProfileResponse;
import com.candidates.model.PersonalDetails;
import com.candidates.model.Skills;
import com.candidates.model.UnreadNotificationResponse;
import com.candidates.model.WorkExperience;
import com.candidates.util.CandidatesConstants;
import com.candidates.util.QueryConstants;

@Repository
public class CandidatesProfileDaoImpl extends JdbcDaoSupport implements CandidatesProfileDao{
	
	@Autowired
	DataSource dataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}
	
	public CandidatesSkillResponse getCandidateSkills(String email){
		
		/*CandidatesSkillResponse candidatesSkillResponse = new CandidatesSkillResponse();
		candidatesSkillResponse.setId("a0V0Q000000DQaGUAB");
		candidatesSkillResponse.setLanguage("English;French;German");
		return candidatesSkillResponse;*/
		
		String sql = QueryConstants.GET_SKILLS;
		CandidatesSkillResponse candidatesSkillResponse = new CandidatesSkillResponse();
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql,new Object[]{email.toUpperCase()});
		if (null != rows && rows.size() > 0) {
			for (Map<String, Object> row : rows) {
				if(null != row){
					candidatesSkillResponse.setId((null == row.get(QueryConstants.COLUMN_SF_ID) ? "": (String) row.get(QueryConstants.COLUMN_SF_ID)));
					candidatesSkillResponse.setLanguage(null == row.get(QueryConstants.COLUMN_LANGUAGE) ? "": (String) row.get(QueryConstants.COLUMN_LANGUAGE));
					
				}
				
			}
		}
		return candidatesSkillResponse;
	}
	
	public List<CandidatesEducationResponse> getCandidateEducation(String email){
		/*List<CandidatesEducationResponse> candidatesEducationResponseList = new ArrayList();
		CandidatesEducationResponse candidatesEducationResponse = new CandidatesEducationResponse();
		candidatesEducationResponse.setQualificationName("BE");
		candidatesEducationResponse.setQualificationType("Graduation");
		candidatesEducationResponse.setStartYear("10/30/2014");
		candidatesEducationResponse.setEndYear("10/30/2018");
		candidatesEducationResponse.setId("a0V0Q000000DQaGUAQ");
		
		CandidatesEducationResponse candidatesEducationResponse1 = new CandidatesEducationResponse();
		candidatesEducationResponse1.setQualificationName("Masters");
		candidatesEducationResponse1.setQualificationType("PG");
		candidatesEducationResponse1.setStartYear("12/30/2018");
		candidatesEducationResponse1.setEndYear("10/30/2020");
		candidatesEducationResponse1.setId("a0V0Q000000DQaGUAB");
		
		candidatesEducationResponseList.add(candidatesEducationResponse);
		candidatesEducationResponseList.add(candidatesEducationResponse1);
		
		return candidatesEducationResponseList;*/
		
		String sql = QueryConstants.GET_CANDIDATES_EDUCATION;
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql,new Object[]{email.toUpperCase()});
		List<CandidatesEducationResponse> result = new ArrayList<CandidatesEducationResponse>();
		if (null != rows && rows.size() > 0) {
			for (Map<String, Object> row : rows) {
				if(null != row){
					CandidatesEducationResponse candidatesEducationResponse = new CandidatesEducationResponse();
					candidatesEducationResponse.setId((null == row.get(QueryConstants.COLUMN_SF_ID) ? "": (String) row.get(QueryConstants.COLUMN_SF_ID)));
					candidatesEducationResponse.setQualificationName((null == row.get(QueryConstants.COLUMN_QUALIFICATION_NAME) ? "": (String) row.get(QueryConstants.COLUMN_QUALIFICATION_NAME)));
					candidatesEducationResponse.setQualificationType((null == row.get(QueryConstants.COLUMN_QUALIFICATION_TYPE)? "": (String) row.get(QueryConstants.COLUMN_QUALIFICATION_TYPE)));
					candidatesEducationResponse.setStartYear((null == row.get(QueryConstants.COLUMN_START_DATE)? "": (String) row.get(QueryConstants.COLUMN_START_DATE)));
					candidatesEducationResponse.setEndYear((null == row.get(QueryConstants.COLUMN_END_DATE)? "": (String) row.get(QueryConstants.COLUMN_END_DATE)));
					result.add(candidatesEducationResponse);
				}
				
			}
		}
		return result;
	}
	
	public List<CandidateWorkExpResponse> getCandidateWorkExperiences(String email){
		/*List<CandidateWorkExpResponse> candidateWorkExpResponseList = new ArrayList();
		
		CandidateWorkExpResponse candidateWorkExpResponse = new CandidateWorkExpResponse();
		CandidateWorkExpResponse candidateWorkExpResponse1 = new CandidateWorkExpResponse();
		
		candidateWorkExpResponse.setId("a0V0Q000000DQaGUAB");
		candidateWorkExpResponse.setCompanyName("Adecco");
		candidateWorkExpResponse.setJobDescription("BA");
		candidateWorkExpResponse.setStartDate("12/12/2015");
		candidateWorkExpResponse.setEndDate("10/30/2018");
		candidateWorkExpResponse.setJobTitle("Working in Adecco as BA");
		candidateWorkExpResponse.setLocation("US");
		
		candidateWorkExpResponse1.setId("a0V0Q000000DQaGUAK");
		candidateWorkExpResponse1.setCompanyName("Accenture");
		candidateWorkExpResponse1.setJobDescription("Developer");
		candidateWorkExpResponse1.setStartDate("12/09/2012");
		candidateWorkExpResponse1.setEndDate("10/11/2014");
		candidateWorkExpResponse1.setJobTitle("Working in Accenture as Developer");
		candidateWorkExpResponse1.setLocation("France");
		
		candidateWorkExpResponseList.add(candidateWorkExpResponse);
		candidateWorkExpResponseList.add(candidateWorkExpResponse1);
		
		return candidateWorkExpResponseList;*/
		
		String sql = QueryConstants.GET_WORK_EXP;
		logger.info("Email id used while fetching the records- "+email);
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql,new Object[]{email.toUpperCase()});
		logger.info("----- rows ---fetched in getworkexp - > "+rows);
		List<CandidateWorkExpResponse> result = new ArrayList<CandidateWorkExpResponse>();
		if (null != rows && rows.size() > 0) {
			for (Map<String, Object> row : rows) {
				if(null != row){
					CandidateWorkExpResponse candidateWorkExpResponse = new CandidateWorkExpResponse();
					candidateWorkExpResponse.setId((null == row.get(QueryConstants.COLUMN_SF_ID) ? "": (String) row.get(QueryConstants.COLUMN_SF_ID)));
					candidateWorkExpResponse.setCompanyName((null == row.get(QueryConstants.COLUMN_COMPANY_NAME) ? "": (String) row.get(QueryConstants.COLUMN_COMPANY_NAME)));
					candidateWorkExpResponse.setJobDescription((null == row.get(QueryConstants.COLUMN_WORK_EXP_DESC)? "": (String) row.get(QueryConstants.COLUMN_WORK_EXP_DESC)));
					candidateWorkExpResponse.setJobTitle((null == row.get(QueryConstants.COLUMN_WORK_EXP_TITLE)? "": (String) row.get(QueryConstants.COLUMN_WORK_EXP_TITLE)));
					candidateWorkExpResponse.setLocation((null == row.get(QueryConstants.COLUMN_COMPANY_LOCATION)? "": (String) row.get(QueryConstants.COLUMN_COMPANY_LOCATION)));
					candidateWorkExpResponse.setStartDate((null == row.get(QueryConstants.COLUMN_START_DATE)? "": (String) row.get(QueryConstants.COLUMN_START_DATE)));
					candidateWorkExpResponse.setEndDate((null == row.get(QueryConstants.COLUMN_END_DATE)? "": (String) row.get(QueryConstants.COLUMN_END_DATE)));
					result.add(candidateWorkExpResponse);
				}
				
			}
		}
		logger.info("------get work experiences result- "+result);
		return result;
		
	}
	
	public DataHistoryResponse getDataHistory(String email){
		/*List<DataHistoryResponse> dataHistoryResponseList = new ArrayList();
		DataHistoryResponse dataHistoryResponse = new DataHistoryResponse();
		dataHistoryResponse.setStatusPortability(true);
		dataHistoryResponse.setStatusDataAccess(false);
		dataHistoryResponseList.add(dataHistoryResponse);
		return dataHistoryResponseList;*/
		
		String sql = QueryConstants.GET_DATA_HISTORY;
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql,new Object[]{email.toUpperCase()});
		String reason = "";
		String status = "";
		DataHistoryResponse dataHistoryResponse = new DataHistoryResponse();
		if (null != rows && rows.size() > 0) {
			for (Map<String, Object> row : rows) {
				if(null != row){
					
					 reason = (null == row.get(QueryConstants.COLUMN_REASON) ? "": (String) row.get(QueryConstants.COLUMN_REASON));
					 status = (null == row.get(QueryConstants.COLUMN_STATUS)? "": (String) row.get(QueryConstants.COLUMN_STATUS));
					
					 logger.info("Reason - > "+reason+" status - > "+status);
					 if(reason.equalsIgnoreCase(CandidatesConstants.PORTABILITY)) {
						 dataHistoryResponse.setStatusPortability(setBooleanValue(status));
					 }else if(reason.equalsIgnoreCase(CandidatesConstants.DATA_ACCESS)){
						 dataHistoryResponse.setStatusDataAccess(setBooleanValue(status));
					 }
					
					
				}
				
			}
		}
		return dataHistoryResponse;
		
	}
	
	public GetProfileResponse getProfile(String emailId){
		GetProfileResponse getProfileResponse = new GetProfileResponse();
		DocumentResponse document= new DocumentResponse();
		document.setDateAdded("10/10/2018");
		document.setName("Resume");
		document.setUrl("C:\\Adecco");
		document.setId("a0V0Q000000DQaGUAQ");
		getProfileResponse.setDocument(document);
		
		Education education = new Education();
		education.setName("MBA");
		education.setId("a0V0Q000000DQaGUYT");
		getProfileResponse.setEducation(education);
		
		PersonalDetails personalDetails = new PersonalDetails();
		personalDetails.setName("Riddhi Gambhir");
		personalDetails.setId("a0V0Q000000DQaGUAA");
		getProfileResponse.setPersonalDetail(personalDetails);
		
		Skills skills = new Skills();
		skills.setId("a0V0Q000000DQaGUAQ");
		skills.setName("English;French;Spanish");
		
		getProfileResponse.setSkills(skills);
		
		WorkExperience workExperience = new WorkExperience();
		workExperience.setId("a0V0Q000000DQaGUOP");
		workExperience.setName("Adecco");
		
		getProfileResponse.setWorkExperience(workExperience);
		return getProfileResponse;
	}
	
	public UnreadNotificationResponse getUnreadNotificationsCount(String email){
		/*UnreadNotificationResponse unreadNotificationResponse = new UnreadNotificationResponse();
		unreadNotificationResponse.setCount("3");
		return unreadNotificationResponse;*/
		
		String sql = QueryConstants.GET_OPEN_NOTIFICATIONS;
		Integer count = getJdbcTemplate().queryForObject(
                sql, new Object[] { email.toUpperCase() }, Integer.class);

		UnreadNotificationResponse unreadNotificationResponse = new UnreadNotificationResponse();
		unreadNotificationResponse.setCount(String.valueOf(count));
        return  unreadNotificationResponse;
		
	}

	private boolean setBooleanValue(String value){
		boolean result=false;
		if(!value.equals("")){
			if(value.equalsIgnoreCase(CandidatesConstants.OPEN)){
				result = true;
			}else if(value.equalsIgnoreCase(CandidatesConstants.CLOSE)) {
				result = false;
			}
		}
		return result;
	}
}
