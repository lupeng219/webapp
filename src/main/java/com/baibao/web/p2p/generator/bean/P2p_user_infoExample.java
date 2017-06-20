package com.baibao.web.p2p.generator.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class P2p_user_infoExample implements Serializable{
   
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public P2p_user_infoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andPuiIdIsNull() {
            addCriterion("pui_id is null");
            return (Criteria) this;
        }

        public Criteria andPuiIdIsNotNull() {
            addCriterion("pui_id is not null");
            return (Criteria) this;
        }

        public Criteria andPuiIdEqualTo(Long value) {
            addCriterion("pui_id =", value, "puiId");
            return (Criteria) this;
        }

        public Criteria andPuiIdNotEqualTo(Long value) {
            addCriterion("pui_id <>", value, "puiId");
            return (Criteria) this;
        }

        public Criteria andPuiIdGreaterThan(Long value) {
            addCriterion("pui_id >", value, "puiId");
            return (Criteria) this;
        }

        public Criteria andPuiIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pui_id >=", value, "puiId");
            return (Criteria) this;
        }

        public Criteria andPuiIdLessThan(Long value) {
            addCriterion("pui_id <", value, "puiId");
            return (Criteria) this;
        }

        public Criteria andPuiIdLessThanOrEqualTo(Long value) {
            addCriterion("pui_id <=", value, "puiId");
            return (Criteria) this;
        }

        public Criteria andPuiIdIn(List<Long> values) {
            addCriterion("pui_id in", values, "puiId");
            return (Criteria) this;
        }

        public Criteria andPuiIdNotIn(List<Long> values) {
            addCriterion("pui_id not in", values, "puiId");
            return (Criteria) this;
        }

        public Criteria andPuiIdBetween(Long value1, Long value2) {
            addCriterion("pui_id between", value1, value2, "puiId");
            return (Criteria) this;
        }

        public Criteria andPuiIdNotBetween(Long value1, Long value2) {
            addCriterion("pui_id not between", value1, value2, "puiId");
            return (Criteria) this;
        }

        public Criteria andPuiCustnoIsNull() {
            addCriterion("pui_custNo is null");
            return (Criteria) this;
        }

        public Criteria andPuiCustnoIsNotNull() {
            addCriterion("pui_custNo is not null");
            return (Criteria) this;
        }

        public Criteria andPuiCustnoEqualTo(String value) {
            addCriterion("pui_custNo =", value, "puiCustno");
            return (Criteria) this;
        }

        public Criteria andPuiCustnoNotEqualTo(String value) {
            addCriterion("pui_custNo <>", value, "puiCustno");
            return (Criteria) this;
        }

        public Criteria andPuiCustnoGreaterThan(String value) {
            addCriterion("pui_custNo >", value, "puiCustno");
            return (Criteria) this;
        }

        public Criteria andPuiCustnoGreaterThanOrEqualTo(String value) {
            addCriterion("pui_custNo >=", value, "puiCustno");
            return (Criteria) this;
        }

        public Criteria andPuiCustnoLessThan(String value) {
            addCriterion("pui_custNo <", value, "puiCustno");
            return (Criteria) this;
        }

        public Criteria andPuiCustnoLessThanOrEqualTo(String value) {
            addCriterion("pui_custNo <=", value, "puiCustno");
            return (Criteria) this;
        }

        public Criteria andPuiCustnoLike(String value) {
            addCriterion("pui_custNo like", value, "puiCustno");
            return (Criteria) this;
        }

        public Criteria andPuiCustnoNotLike(String value) {
            addCriterion("pui_custNo not like", value, "puiCustno");
            return (Criteria) this;
        }

        public Criteria andPuiCustnoIn(List<String> values) {
            addCriterion("pui_custNo in", values, "puiCustno");
            return (Criteria) this;
        }

        public Criteria andPuiCustnoNotIn(List<String> values) {
            addCriterion("pui_custNo not in", values, "puiCustno");
            return (Criteria) this;
        }

        public Criteria andPuiCustnoBetween(String value1, String value2) {
            addCriterion("pui_custNo between", value1, value2, "puiCustno");
            return (Criteria) this;
        }

        public Criteria andPuiCustnoNotBetween(String value1, String value2) {
            addCriterion("pui_custNo not between", value1, value2, "puiCustno");
            return (Criteria) this;
        }

        public Criteria andPuiPlatGradeIsNull() {
            addCriterion("pui_plat_grade is null");
            return (Criteria) this;
        }

        public Criteria andPuiPlatGradeIsNotNull() {
            addCriterion("pui_plat_grade is not null");
            return (Criteria) this;
        }

        public Criteria andPuiPlatGradeEqualTo(String value) {
            addCriterion("pui_plat_grade =", value, "puiPlatGrade");
            return (Criteria) this;
        }

        public Criteria andPuiPlatGradeNotEqualTo(String value) {
            addCriterion("pui_plat_grade <>", value, "puiPlatGrade");
            return (Criteria) this;
        }

        public Criteria andPuiPlatGradeGreaterThan(String value) {
            addCriterion("pui_plat_grade >", value, "puiPlatGrade");
            return (Criteria) this;
        }

        public Criteria andPuiPlatGradeGreaterThanOrEqualTo(String value) {
            addCriterion("pui_plat_grade >=", value, "puiPlatGrade");
            return (Criteria) this;
        }

        public Criteria andPuiPlatGradeLessThan(String value) {
            addCriterion("pui_plat_grade <", value, "puiPlatGrade");
            return (Criteria) this;
        }

        public Criteria andPuiPlatGradeLessThanOrEqualTo(String value) {
            addCriterion("pui_plat_grade <=", value, "puiPlatGrade");
            return (Criteria) this;
        }

        public Criteria andPuiPlatGradeLike(String value) {
            addCriterion("pui_plat_grade like", value, "puiPlatGrade");
            return (Criteria) this;
        }

        public Criteria andPuiPlatGradeNotLike(String value) {
            addCriterion("pui_plat_grade not like", value, "puiPlatGrade");
            return (Criteria) this;
        }

        public Criteria andPuiPlatGradeIn(List<String> values) {
            addCriterion("pui_plat_grade in", values, "puiPlatGrade");
            return (Criteria) this;
        }

        public Criteria andPuiPlatGradeNotIn(List<String> values) {
            addCriterion("pui_plat_grade not in", values, "puiPlatGrade");
            return (Criteria) this;
        }

        public Criteria andPuiPlatGradeBetween(String value1, String value2) {
            addCriterion("pui_plat_grade between", value1, value2, "puiPlatGrade");
            return (Criteria) this;
        }

        public Criteria andPuiPlatGradeNotBetween(String value1, String value2) {
            addCriterion("pui_plat_grade not between", value1, value2, "puiPlatGrade");
            return (Criteria) this;
        }

        public Criteria andPuiPlatScoreIsNull() {
            addCriterion("pui_plat_score is null");
            return (Criteria) this;
        }

        public Criteria andPuiPlatScoreIsNotNull() {
            addCriterion("pui_plat_score is not null");
            return (Criteria) this;
        }

        public Criteria andPuiPlatScoreEqualTo(String value) {
            addCriterion("pui_plat_score =", value, "puiPlatScore");
            return (Criteria) this;
        }

        public Criteria andPuiPlatScoreNotEqualTo(String value) {
            addCriterion("pui_plat_score <>", value, "puiPlatScore");
            return (Criteria) this;
        }

        public Criteria andPuiPlatScoreGreaterThan(String value) {
            addCriterion("pui_plat_score >", value, "puiPlatScore");
            return (Criteria) this;
        }

        public Criteria andPuiPlatScoreGreaterThanOrEqualTo(String value) {
            addCriterion("pui_plat_score >=", value, "puiPlatScore");
            return (Criteria) this;
        }

        public Criteria andPuiPlatScoreLessThan(String value) {
            addCriterion("pui_plat_score <", value, "puiPlatScore");
            return (Criteria) this;
        }

        public Criteria andPuiPlatScoreLessThanOrEqualTo(String value) {
            addCriterion("pui_plat_score <=", value, "puiPlatScore");
            return (Criteria) this;
        }

        public Criteria andPuiPlatScoreLike(String value) {
            addCriterion("pui_plat_score like", value, "puiPlatScore");
            return (Criteria) this;
        }

        public Criteria andPuiPlatScoreNotLike(String value) {
            addCriterion("pui_plat_score not like", value, "puiPlatScore");
            return (Criteria) this;
        }

        public Criteria andPuiPlatScoreIn(List<String> values) {
            addCriterion("pui_plat_score in", values, "puiPlatScore");
            return (Criteria) this;
        }

        public Criteria andPuiPlatScoreNotIn(List<String> values) {
            addCriterion("pui_plat_score not in", values, "puiPlatScore");
            return (Criteria) this;
        }

        public Criteria andPuiPlatScoreBetween(String value1, String value2) {
            addCriterion("pui_plat_score between", value1, value2, "puiPlatScore");
            return (Criteria) this;
        }

        public Criteria andPuiPlatScoreNotBetween(String value1, String value2) {
            addCriterion("pui_plat_score not between", value1, value2, "puiPlatScore");
            return (Criteria) this;
        }

        public Criteria andPuiMobilebindtimeIsNull() {
            addCriterion("pui_mobileBindTime is null");
            return (Criteria) this;
        }

        public Criteria andPuiMobilebindtimeIsNotNull() {
            addCriterion("pui_mobileBindTime is not null");
            return (Criteria) this;
        }

        public Criteria andPuiMobilebindtimeEqualTo(Date value) {
            addCriterion("pui_mobileBindTime =", value, "puiMobilebindtime");
            return (Criteria) this;
        }

        public Criteria andPuiMobilebindtimeNotEqualTo(Date value) {
            addCriterion("pui_mobileBindTime <>", value, "puiMobilebindtime");
            return (Criteria) this;
        }

        public Criteria andPuiMobilebindtimeGreaterThan(Date value) {
            addCriterion("pui_mobileBindTime >", value, "puiMobilebindtime");
            return (Criteria) this;
        }

        public Criteria andPuiMobilebindtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pui_mobileBindTime >=", value, "puiMobilebindtime");
            return (Criteria) this;
        }

        public Criteria andPuiMobilebindtimeLessThan(Date value) {
            addCriterion("pui_mobileBindTime <", value, "puiMobilebindtime");
            return (Criteria) this;
        }

        public Criteria andPuiMobilebindtimeLessThanOrEqualTo(Date value) {
            addCriterion("pui_mobileBindTime <=", value, "puiMobilebindtime");
            return (Criteria) this;
        }

        public Criteria andPuiMobilebindtimeIn(List<Date> values) {
            addCriterion("pui_mobileBindTime in", values, "puiMobilebindtime");
            return (Criteria) this;
        }

        public Criteria andPuiMobilebindtimeNotIn(List<Date> values) {
            addCriterion("pui_mobileBindTime not in", values, "puiMobilebindtime");
            return (Criteria) this;
        }

        public Criteria andPuiMobilebindtimeBetween(Date value1, Date value2) {
            addCriterion("pui_mobileBindTime between", value1, value2, "puiMobilebindtime");
            return (Criteria) this;
        }

        public Criteria andPuiMobilebindtimeNotBetween(Date value1, Date value2) {
            addCriterion("pui_mobileBindTime not between", value1, value2, "puiMobilebindtime");
            return (Criteria) this;
        }

        public Criteria andPuiEmailbindtimeIsNull() {
            addCriterion("pui_emailBindTime is null");
            return (Criteria) this;
        }

        public Criteria andPuiEmailbindtimeIsNotNull() {
            addCriterion("pui_emailBindTime is not null");
            return (Criteria) this;
        }

        public Criteria andPuiEmailbindtimeEqualTo(Date value) {
            addCriterion("pui_emailBindTime =", value, "puiEmailbindtime");
            return (Criteria) this;
        }

        public Criteria andPuiEmailbindtimeNotEqualTo(Date value) {
            addCriterion("pui_emailBindTime <>", value, "puiEmailbindtime");
            return (Criteria) this;
        }

        public Criteria andPuiEmailbindtimeGreaterThan(Date value) {
            addCriterion("pui_emailBindTime >", value, "puiEmailbindtime");
            return (Criteria) this;
        }

        public Criteria andPuiEmailbindtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pui_emailBindTime >=", value, "puiEmailbindtime");
            return (Criteria) this;
        }

        public Criteria andPuiEmailbindtimeLessThan(Date value) {
            addCriterion("pui_emailBindTime <", value, "puiEmailbindtime");
            return (Criteria) this;
        }

        public Criteria andPuiEmailbindtimeLessThanOrEqualTo(Date value) {
            addCriterion("pui_emailBindTime <=", value, "puiEmailbindtime");
            return (Criteria) this;
        }

        public Criteria andPuiEmailbindtimeIn(List<Date> values) {
            addCriterion("pui_emailBindTime in", values, "puiEmailbindtime");
            return (Criteria) this;
        }

        public Criteria andPuiEmailbindtimeNotIn(List<Date> values) {
            addCriterion("pui_emailBindTime not in", values, "puiEmailbindtime");
            return (Criteria) this;
        }

        public Criteria andPuiEmailbindtimeBetween(Date value1, Date value2) {
            addCriterion("pui_emailBindTime between", value1, value2, "puiEmailbindtime");
            return (Criteria) this;
        }

        public Criteria andPuiEmailbindtimeNotBetween(Date value1, Date value2) {
            addCriterion("pui_emailBindTime not between", value1, value2, "puiEmailbindtime");
            return (Criteria) this;
        }

        public Criteria andPuiPlataccountiscertIsNull() {
            addCriterion("pui_platAccountIsCert is null");
            return (Criteria) this;
        }

        public Criteria andPuiPlataccountiscertIsNotNull() {
            addCriterion("pui_platAccountIsCert is not null");
            return (Criteria) this;
        }

        public Criteria andPuiPlataccountiscertEqualTo(String value) {
            addCriterion("pui_platAccountIsCert =", value, "puiPlataccountiscert");
            return (Criteria) this;
        }

        public Criteria andPuiPlataccountiscertNotEqualTo(String value) {
            addCriterion("pui_platAccountIsCert <>", value, "puiPlataccountiscert");
            return (Criteria) this;
        }

        public Criteria andPuiPlataccountiscertGreaterThan(String value) {
            addCriterion("pui_platAccountIsCert >", value, "puiPlataccountiscert");
            return (Criteria) this;
        }

        public Criteria andPuiPlataccountiscertGreaterThanOrEqualTo(String value) {
            addCriterion("pui_platAccountIsCert >=", value, "puiPlataccountiscert");
            return (Criteria) this;
        }

        public Criteria andPuiPlataccountiscertLessThan(String value) {
            addCriterion("pui_platAccountIsCert <", value, "puiPlataccountiscert");
            return (Criteria) this;
        }

        public Criteria andPuiPlataccountiscertLessThanOrEqualTo(String value) {
            addCriterion("pui_platAccountIsCert <=", value, "puiPlataccountiscert");
            return (Criteria) this;
        }

        public Criteria andPuiPlataccountiscertLike(String value) {
            addCriterion("pui_platAccountIsCert like", value, "puiPlataccountiscert");
            return (Criteria) this;
        }

        public Criteria andPuiPlataccountiscertNotLike(String value) {
            addCriterion("pui_platAccountIsCert not like", value, "puiPlataccountiscert");
            return (Criteria) this;
        }

        public Criteria andPuiPlataccountiscertIn(List<String> values) {
            addCriterion("pui_platAccountIsCert in", values, "puiPlataccountiscert");
            return (Criteria) this;
        }

        public Criteria andPuiPlataccountiscertNotIn(List<String> values) {
            addCriterion("pui_platAccountIsCert not in", values, "puiPlataccountiscert");
            return (Criteria) this;
        }

        public Criteria andPuiPlataccountiscertBetween(String value1, String value2) {
            addCriterion("pui_platAccountIsCert between", value1, value2, "puiPlataccountiscert");
            return (Criteria) this;
        }

        public Criteria andPuiPlataccountiscertNotBetween(String value1, String value2) {
            addCriterion("pui_platAccountIsCert not between", value1, value2, "puiPlataccountiscert");
            return (Criteria) this;
        }

        public Criteria andPuiRegistrationTimeIsNull() {
            addCriterion("pui_registration_time is null");
            return (Criteria) this;
        }

        public Criteria andPuiRegistrationTimeIsNotNull() {
            addCriterion("pui_registration_time is not null");
            return (Criteria) this;
        }

        public Criteria andPuiRegistrationTimeEqualTo(Date value) {
            addCriterion("pui_registration_time =", value, "puiRegistrationTime");
            return (Criteria) this;
        }

        public Criteria andPuiRegistrationTimeNotEqualTo(Date value) {
            addCriterion("pui_registration_time <>", value, "puiRegistrationTime");
            return (Criteria) this;
        }

        public Criteria andPuiRegistrationTimeGreaterThan(Date value) {
            addCriterion("pui_registration_time >", value, "puiRegistrationTime");
            return (Criteria) this;
        }

        public Criteria andPuiRegistrationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pui_registration_time >=", value, "puiRegistrationTime");
            return (Criteria) this;
        }

        public Criteria andPuiRegistrationTimeLessThan(Date value) {
            addCriterion("pui_registration_time <", value, "puiRegistrationTime");
            return (Criteria) this;
        }

        public Criteria andPuiRegistrationTimeLessThanOrEqualTo(Date value) {
            addCriterion("pui_registration_time <=", value, "puiRegistrationTime");
            return (Criteria) this;
        }

        public Criteria andPuiRegistrationTimeIn(List<Date> values) {
            addCriterion("pui_registration_time in", values, "puiRegistrationTime");
            return (Criteria) this;
        }

        public Criteria andPuiRegistrationTimeNotIn(List<Date> values) {
            addCriterion("pui_registration_time not in", values, "puiRegistrationTime");
            return (Criteria) this;
        }

        public Criteria andPuiRegistrationTimeBetween(Date value1, Date value2) {
            addCriterion("pui_registration_time between", value1, value2, "puiRegistrationTime");
            return (Criteria) this;
        }

        public Criteria andPuiRegistrationTimeNotBetween(Date value1, Date value2) {
            addCriterion("pui_registration_time not between", value1, value2, "puiRegistrationTime");
            return (Criteria) this;
        }

        public Criteria andPuiRealNameIsNull() {
            addCriterion("pui_real_name is null");
            return (Criteria) this;
        }

        public Criteria andPuiRealNameIsNotNull() {
            addCriterion("pui_real_name is not null");
            return (Criteria) this;
        }

        public Criteria andPuiRealNameEqualTo(String value) {
            addCriterion("pui_real_name =", value, "puiRealName");
            return (Criteria) this;
        }

        public Criteria andPuiRealNameNotEqualTo(String value) {
            addCriterion("pui_real_name <>", value, "puiRealName");
            return (Criteria) this;
        }

        public Criteria andPuiRealNameGreaterThan(String value) {
            addCriterion("pui_real_name >", value, "puiRealName");
            return (Criteria) this;
        }

        public Criteria andPuiRealNameGreaterThanOrEqualTo(String value) {
            addCriterion("pui_real_name >=", value, "puiRealName");
            return (Criteria) this;
        }

        public Criteria andPuiRealNameLessThan(String value) {
            addCriterion("pui_real_name <", value, "puiRealName");
            return (Criteria) this;
        }

        public Criteria andPuiRealNameLessThanOrEqualTo(String value) {
            addCriterion("pui_real_name <=", value, "puiRealName");
            return (Criteria) this;
        }

        public Criteria andPuiRealNameLike(String value) {
            addCriterion("pui_real_name like", value, "puiRealName");
            return (Criteria) this;
        }

        public Criteria andPuiRealNameNotLike(String value) {
            addCriterion("pui_real_name not like", value, "puiRealName");
            return (Criteria) this;
        }

        public Criteria andPuiRealNameIn(List<String> values) {
            addCriterion("pui_real_name in", values, "puiRealName");
            return (Criteria) this;
        }

        public Criteria andPuiRealNameNotIn(List<String> values) {
            addCriterion("pui_real_name not in", values, "puiRealName");
            return (Criteria) this;
        }

        public Criteria andPuiRealNameBetween(String value1, String value2) {
            addCriterion("pui_real_name between", value1, value2, "puiRealName");
            return (Criteria) this;
        }

        public Criteria andPuiRealNameNotBetween(String value1, String value2) {
            addCriterion("pui_real_name not between", value1, value2, "puiRealName");
            return (Criteria) this;
        }

        public Criteria andPuiCertTypeIsNull() {
            addCriterion("pui_cert_type is null");
            return (Criteria) this;
        }

        public Criteria andPuiCertTypeIsNotNull() {
            addCriterion("pui_cert_type is not null");
            return (Criteria) this;
        }

        public Criteria andPuiCertTypeEqualTo(String value) {
            addCriterion("pui_cert_type =", value, "puiCertType");
            return (Criteria) this;
        }

        public Criteria andPuiCertTypeNotEqualTo(String value) {
            addCriterion("pui_cert_type <>", value, "puiCertType");
            return (Criteria) this;
        }

        public Criteria andPuiCertTypeGreaterThan(String value) {
            addCriterion("pui_cert_type >", value, "puiCertType");
            return (Criteria) this;
        }

        public Criteria andPuiCertTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pui_cert_type >=", value, "puiCertType");
            return (Criteria) this;
        }

        public Criteria andPuiCertTypeLessThan(String value) {
            addCriterion("pui_cert_type <", value, "puiCertType");
            return (Criteria) this;
        }

        public Criteria andPuiCertTypeLessThanOrEqualTo(String value) {
            addCriterion("pui_cert_type <=", value, "puiCertType");
            return (Criteria) this;
        }

        public Criteria andPuiCertTypeLike(String value) {
            addCriterion("pui_cert_type like", value, "puiCertType");
            return (Criteria) this;
        }

        public Criteria andPuiCertTypeNotLike(String value) {
            addCriterion("pui_cert_type not like", value, "puiCertType");
            return (Criteria) this;
        }

        public Criteria andPuiCertTypeIn(List<String> values) {
            addCriterion("pui_cert_type in", values, "puiCertType");
            return (Criteria) this;
        }

        public Criteria andPuiCertTypeNotIn(List<String> values) {
            addCriterion("pui_cert_type not in", values, "puiCertType");
            return (Criteria) this;
        }

        public Criteria andPuiCertTypeBetween(String value1, String value2) {
            addCriterion("pui_cert_type between", value1, value2, "puiCertType");
            return (Criteria) this;
        }

        public Criteria andPuiCertTypeNotBetween(String value1, String value2) {
            addCriterion("pui_cert_type not between", value1, value2, "puiCertType");
            return (Criteria) this;
        }

        public Criteria andPuiCertNoIsNull() {
            addCriterion("pui_cert_no is null");
            return (Criteria) this;
        }

        public Criteria andPuiCertNoIsNotNull() {
            addCriterion("pui_cert_no is not null");
            return (Criteria) this;
        }

        public Criteria andPuiCertNoEqualTo(String value) {
            addCriterion("pui_cert_no =", value, "puiCertNo");
            return (Criteria) this;
        }

        public Criteria andPuiCertNoNotEqualTo(String value) {
            addCriterion("pui_cert_no <>", value, "puiCertNo");
            return (Criteria) this;
        }

        public Criteria andPuiCertNoGreaterThan(String value) {
            addCriterion("pui_cert_no >", value, "puiCertNo");
            return (Criteria) this;
        }

        public Criteria andPuiCertNoGreaterThanOrEqualTo(String value) {
            addCriterion("pui_cert_no >=", value, "puiCertNo");
            return (Criteria) this;
        }

        public Criteria andPuiCertNoLessThan(String value) {
            addCriterion("pui_cert_no <", value, "puiCertNo");
            return (Criteria) this;
        }

        public Criteria andPuiCertNoLessThanOrEqualTo(String value) {
            addCriterion("pui_cert_no <=", value, "puiCertNo");
            return (Criteria) this;
        }

        public Criteria andPuiCertNoLike(String value) {
            addCriterion("pui_cert_no like", value, "puiCertNo");
            return (Criteria) this;
        }

        public Criteria andPuiCertNoNotLike(String value) {
            addCriterion("pui_cert_no not like", value, "puiCertNo");
            return (Criteria) this;
        }

        public Criteria andPuiCertNoIn(List<String> values) {
            addCriterion("pui_cert_no in", values, "puiCertNo");
            return (Criteria) this;
        }

        public Criteria andPuiCertNoNotIn(List<String> values) {
            addCriterion("pui_cert_no not in", values, "puiCertNo");
            return (Criteria) this;
        }

        public Criteria andPuiCertNoBetween(String value1, String value2) {
            addCriterion("pui_cert_no between", value1, value2, "puiCertNo");
            return (Criteria) this;
        }

        public Criteria andPuiCertNoNotBetween(String value1, String value2) {
            addCriterion("pui_cert_no not between", value1, value2, "puiCertNo");
            return (Criteria) this;
        }

        public Criteria andPuiAgeIsNull() {
            addCriterion("pui_age is null");
            return (Criteria) this;
        }

        public Criteria andPuiAgeIsNotNull() {
            addCriterion("pui_age is not null");
            return (Criteria) this;
        }

        public Criteria andPuiAgeEqualTo(String value) {
            addCriterion("pui_age =", value, "puiAge");
            return (Criteria) this;
        }

        public Criteria andPuiAgeNotEqualTo(String value) {
            addCriterion("pui_age <>", value, "puiAge");
            return (Criteria) this;
        }

        public Criteria andPuiAgeGreaterThan(String value) {
            addCriterion("pui_age >", value, "puiAge");
            return (Criteria) this;
        }

        public Criteria andPuiAgeGreaterThanOrEqualTo(String value) {
            addCriterion("pui_age >=", value, "puiAge");
            return (Criteria) this;
        }

        public Criteria andPuiAgeLessThan(String value) {
            addCriterion("pui_age <", value, "puiAge");
            return (Criteria) this;
        }

        public Criteria andPuiAgeLessThanOrEqualTo(String value) {
            addCriterion("pui_age <=", value, "puiAge");
            return (Criteria) this;
        }

        public Criteria andPuiAgeLike(String value) {
            addCriterion("pui_age like", value, "puiAge");
            return (Criteria) this;
        }

        public Criteria andPuiAgeNotLike(String value) {
            addCriterion("pui_age not like", value, "puiAge");
            return (Criteria) this;
        }

        public Criteria andPuiAgeIn(List<String> values) {
            addCriterion("pui_age in", values, "puiAge");
            return (Criteria) this;
        }

        public Criteria andPuiAgeNotIn(List<String> values) {
            addCriterion("pui_age not in", values, "puiAge");
            return (Criteria) this;
        }

        public Criteria andPuiAgeBetween(String value1, String value2) {
            addCriterion("pui_age between", value1, value2, "puiAge");
            return (Criteria) this;
        }

        public Criteria andPuiAgeNotBetween(String value1, String value2) {
            addCriterion("pui_age not between", value1, value2, "puiAge");
            return (Criteria) this;
        }

        public Criteria andPuiSexIsNull() {
            addCriterion("pui_sex is null");
            return (Criteria) this;
        }

        public Criteria andPuiSexIsNotNull() {
            addCriterion("pui_sex is not null");
            return (Criteria) this;
        }

        public Criteria andPuiSexEqualTo(String value) {
            addCriterion("pui_sex =", value, "puiSex");
            return (Criteria) this;
        }

        public Criteria andPuiSexNotEqualTo(String value) {
            addCriterion("pui_sex <>", value, "puiSex");
            return (Criteria) this;
        }

        public Criteria andPuiSexGreaterThan(String value) {
            addCriterion("pui_sex >", value, "puiSex");
            return (Criteria) this;
        }

        public Criteria andPuiSexGreaterThanOrEqualTo(String value) {
            addCriterion("pui_sex >=", value, "puiSex");
            return (Criteria) this;
        }

        public Criteria andPuiSexLessThan(String value) {
            addCriterion("pui_sex <", value, "puiSex");
            return (Criteria) this;
        }

        public Criteria andPuiSexLessThanOrEqualTo(String value) {
            addCriterion("pui_sex <=", value, "puiSex");
            return (Criteria) this;
        }

        public Criteria andPuiSexLike(String value) {
            addCriterion("pui_sex like", value, "puiSex");
            return (Criteria) this;
        }

        public Criteria andPuiSexNotLike(String value) {
            addCriterion("pui_sex not like", value, "puiSex");
            return (Criteria) this;
        }

        public Criteria andPuiSexIn(List<String> values) {
            addCriterion("pui_sex in", values, "puiSex");
            return (Criteria) this;
        }

        public Criteria andPuiSexNotIn(List<String> values) {
            addCriterion("pui_sex not in", values, "puiSex");
            return (Criteria) this;
        }

        public Criteria andPuiSexBetween(String value1, String value2) {
            addCriterion("pui_sex between", value1, value2, "puiSex");
            return (Criteria) this;
        }

        public Criteria andPuiSexNotBetween(String value1, String value2) {
            addCriterion("pui_sex not between", value1, value2, "puiSex");
            return (Criteria) this;
        }

        public Criteria andPuiBirthdayIsNull() {
            addCriterion("pui_birthday is null");
            return (Criteria) this;
        }

        public Criteria andPuiBirthdayIsNotNull() {
            addCriterion("pui_birthday is not null");
            return (Criteria) this;
        }

        public Criteria andPuiBirthdayEqualTo(String value) {
            addCriterion("pui_birthday =", value, "puiBirthday");
            return (Criteria) this;
        }

        public Criteria andPuiBirthdayNotEqualTo(String value) {
            addCriterion("pui_birthday <>", value, "puiBirthday");
            return (Criteria) this;
        }

        public Criteria andPuiBirthdayGreaterThan(String value) {
            addCriterion("pui_birthday >", value, "puiBirthday");
            return (Criteria) this;
        }

        public Criteria andPuiBirthdayGreaterThanOrEqualTo(String value) {
            addCriterion("pui_birthday >=", value, "puiBirthday");
            return (Criteria) this;
        }

        public Criteria andPuiBirthdayLessThan(String value) {
            addCriterion("pui_birthday <", value, "puiBirthday");
            return (Criteria) this;
        }

        public Criteria andPuiBirthdayLessThanOrEqualTo(String value) {
            addCriterion("pui_birthday <=", value, "puiBirthday");
            return (Criteria) this;
        }

        public Criteria andPuiBirthdayLike(String value) {
            addCriterion("pui_birthday like", value, "puiBirthday");
            return (Criteria) this;
        }

        public Criteria andPuiBirthdayNotLike(String value) {
            addCriterion("pui_birthday not like", value, "puiBirthday");
            return (Criteria) this;
        }

        public Criteria andPuiBirthdayIn(List<String> values) {
            addCriterion("pui_birthday in", values, "puiBirthday");
            return (Criteria) this;
        }

        public Criteria andPuiBirthdayNotIn(List<String> values) {
            addCriterion("pui_birthday not in", values, "puiBirthday");
            return (Criteria) this;
        }

        public Criteria andPuiBirthdayBetween(String value1, String value2) {
            addCriterion("pui_birthday between", value1, value2, "puiBirthday");
            return (Criteria) this;
        }

        public Criteria andPuiBirthdayNotBetween(String value1, String value2) {
            addCriterion("pui_birthday not between", value1, value2, "puiBirthday");
            return (Criteria) this;
        }

        public Criteria andPuiEducationIsNull() {
            addCriterion("pui_education is null");
            return (Criteria) this;
        }

        public Criteria andPuiEducationIsNotNull() {
            addCriterion("pui_education is not null");
            return (Criteria) this;
        }

        public Criteria andPuiEducationEqualTo(String value) {
            addCriterion("pui_education =", value, "puiEducation");
            return (Criteria) this;
        }

        public Criteria andPuiEducationNotEqualTo(String value) {
            addCriterion("pui_education <>", value, "puiEducation");
            return (Criteria) this;
        }

        public Criteria andPuiEducationGreaterThan(String value) {
            addCriterion("pui_education >", value, "puiEducation");
            return (Criteria) this;
        }

        public Criteria andPuiEducationGreaterThanOrEqualTo(String value) {
            addCriterion("pui_education >=", value, "puiEducation");
            return (Criteria) this;
        }

        public Criteria andPuiEducationLessThan(String value) {
            addCriterion("pui_education <", value, "puiEducation");
            return (Criteria) this;
        }

        public Criteria andPuiEducationLessThanOrEqualTo(String value) {
            addCriterion("pui_education <=", value, "puiEducation");
            return (Criteria) this;
        }

        public Criteria andPuiEducationLike(String value) {
            addCriterion("pui_education like", value, "puiEducation");
            return (Criteria) this;
        }

        public Criteria andPuiEducationNotLike(String value) {
            addCriterion("pui_education not like", value, "puiEducation");
            return (Criteria) this;
        }

        public Criteria andPuiEducationIn(List<String> values) {
            addCriterion("pui_education in", values, "puiEducation");
            return (Criteria) this;
        }

        public Criteria andPuiEducationNotIn(List<String> values) {
            addCriterion("pui_education not in", values, "puiEducation");
            return (Criteria) this;
        }

        public Criteria andPuiEducationBetween(String value1, String value2) {
            addCriterion("pui_education between", value1, value2, "puiEducation");
            return (Criteria) this;
        }

        public Criteria andPuiEducationNotBetween(String value1, String value2) {
            addCriterion("pui_education not between", value1, value2, "puiEducation");
            return (Criteria) this;
        }

        public Criteria andPuiCollegeIsNull() {
            addCriterion("pui_college is null");
            return (Criteria) this;
        }

        public Criteria andPuiCollegeIsNotNull() {
            addCriterion("pui_college is not null");
            return (Criteria) this;
        }

        public Criteria andPuiCollegeEqualTo(String value) {
            addCriterion("pui_college =", value, "puiCollege");
            return (Criteria) this;
        }

        public Criteria andPuiCollegeNotEqualTo(String value) {
            addCriterion("pui_college <>", value, "puiCollege");
            return (Criteria) this;
        }

        public Criteria andPuiCollegeGreaterThan(String value) {
            addCriterion("pui_college >", value, "puiCollege");
            return (Criteria) this;
        }

        public Criteria andPuiCollegeGreaterThanOrEqualTo(String value) {
            addCriterion("pui_college >=", value, "puiCollege");
            return (Criteria) this;
        }

        public Criteria andPuiCollegeLessThan(String value) {
            addCriterion("pui_college <", value, "puiCollege");
            return (Criteria) this;
        }

        public Criteria andPuiCollegeLessThanOrEqualTo(String value) {
            addCriterion("pui_college <=", value, "puiCollege");
            return (Criteria) this;
        }

        public Criteria andPuiCollegeLike(String value) {
            addCriterion("pui_college like", value, "puiCollege");
            return (Criteria) this;
        }

        public Criteria andPuiCollegeNotLike(String value) {
            addCriterion("pui_college not like", value, "puiCollege");
            return (Criteria) this;
        }

        public Criteria andPuiCollegeIn(List<String> values) {
            addCriterion("pui_college in", values, "puiCollege");
            return (Criteria) this;
        }

        public Criteria andPuiCollegeNotIn(List<String> values) {
            addCriterion("pui_college not in", values, "puiCollege");
            return (Criteria) this;
        }

        public Criteria andPuiCollegeBetween(String value1, String value2) {
            addCriterion("pui_college between", value1, value2, "puiCollege");
            return (Criteria) this;
        }

        public Criteria andPuiCollegeNotBetween(String value1, String value2) {
            addCriterion("pui_college not between", value1, value2, "puiCollege");
            return (Criteria) this;
        }

        public Criteria andPuiMateriaIsNull() {
            addCriterion("pui_materia is null");
            return (Criteria) this;
        }

        public Criteria andPuiMateriaIsNotNull() {
            addCriterion("pui_materia is not null");
            return (Criteria) this;
        }

        public Criteria andPuiMateriaEqualTo(String value) {
            addCriterion("pui_materia =", value, "puiMateria");
            return (Criteria) this;
        }

        public Criteria andPuiMateriaNotEqualTo(String value) {
            addCriterion("pui_materia <>", value, "puiMateria");
            return (Criteria) this;
        }

        public Criteria andPuiMateriaGreaterThan(String value) {
            addCriterion("pui_materia >", value, "puiMateria");
            return (Criteria) this;
        }

        public Criteria andPuiMateriaGreaterThanOrEqualTo(String value) {
            addCriterion("pui_materia >=", value, "puiMateria");
            return (Criteria) this;
        }

        public Criteria andPuiMateriaLessThan(String value) {
            addCriterion("pui_materia <", value, "puiMateria");
            return (Criteria) this;
        }

        public Criteria andPuiMateriaLessThanOrEqualTo(String value) {
            addCriterion("pui_materia <=", value, "puiMateria");
            return (Criteria) this;
        }

        public Criteria andPuiMateriaLike(String value) {
            addCriterion("pui_materia like", value, "puiMateria");
            return (Criteria) this;
        }

        public Criteria andPuiMateriaNotLike(String value) {
            addCriterion("pui_materia not like", value, "puiMateria");
            return (Criteria) this;
        }

        public Criteria andPuiMateriaIn(List<String> values) {
            addCriterion("pui_materia in", values, "puiMateria");
            return (Criteria) this;
        }

        public Criteria andPuiMateriaNotIn(List<String> values) {
            addCriterion("pui_materia not in", values, "puiMateria");
            return (Criteria) this;
        }

        public Criteria andPuiMateriaBetween(String value1, String value2) {
            addCriterion("pui_materia between", value1, value2, "puiMateria");
            return (Criteria) this;
        }

        public Criteria andPuiMateriaNotBetween(String value1, String value2) {
            addCriterion("pui_materia not between", value1, value2, "puiMateria");
            return (Criteria) this;
        }

        public Criteria andPuiAddressIsNull() {
            addCriterion("pui_address is null");
            return (Criteria) this;
        }

        public Criteria andPuiAddressIsNotNull() {
            addCriterion("pui_address is not null");
            return (Criteria) this;
        }

        public Criteria andPuiAddressEqualTo(String value) {
            addCriterion("pui_address =", value, "puiAddress");
            return (Criteria) this;
        }

        public Criteria andPuiAddressNotEqualTo(String value) {
            addCriterion("pui_address <>", value, "puiAddress");
            return (Criteria) this;
        }

        public Criteria andPuiAddressGreaterThan(String value) {
            addCriterion("pui_address >", value, "puiAddress");
            return (Criteria) this;
        }

        public Criteria andPuiAddressGreaterThanOrEqualTo(String value) {
            addCriterion("pui_address >=", value, "puiAddress");
            return (Criteria) this;
        }

        public Criteria andPuiAddressLessThan(String value) {
            addCriterion("pui_address <", value, "puiAddress");
            return (Criteria) this;
        }

        public Criteria andPuiAddressLessThanOrEqualTo(String value) {
            addCriterion("pui_address <=", value, "puiAddress");
            return (Criteria) this;
        }

        public Criteria andPuiAddressLike(String value) {
            addCriterion("pui_address like", value, "puiAddress");
            return (Criteria) this;
        }

        public Criteria andPuiAddressNotLike(String value) {
            addCriterion("pui_address not like", value, "puiAddress");
            return (Criteria) this;
        }

        public Criteria andPuiAddressIn(List<String> values) {
            addCriterion("pui_address in", values, "puiAddress");
            return (Criteria) this;
        }

        public Criteria andPuiAddressNotIn(List<String> values) {
            addCriterion("pui_address not in", values, "puiAddress");
            return (Criteria) this;
        }

        public Criteria andPuiAddressBetween(String value1, String value2) {
            addCriterion("pui_address between", value1, value2, "puiAddress");
            return (Criteria) this;
        }

        public Criteria andPuiAddressNotBetween(String value1, String value2) {
            addCriterion("pui_address not between", value1, value2, "puiAddress");
            return (Criteria) this;
        }

        public Criteria andPuiNativePlaceIsNull() {
            addCriterion("pui_native_place is null");
            return (Criteria) this;
        }

        public Criteria andPuiNativePlaceIsNotNull() {
            addCriterion("pui_native_place is not null");
            return (Criteria) this;
        }

        public Criteria andPuiNativePlaceEqualTo(String value) {
            addCriterion("pui_native_place =", value, "puiNativePlace");
            return (Criteria) this;
        }

        public Criteria andPuiNativePlaceNotEqualTo(String value) {
            addCriterion("pui_native_place <>", value, "puiNativePlace");
            return (Criteria) this;
        }

        public Criteria andPuiNativePlaceGreaterThan(String value) {
            addCriterion("pui_native_place >", value, "puiNativePlace");
            return (Criteria) this;
        }

        public Criteria andPuiNativePlaceGreaterThanOrEqualTo(String value) {
            addCriterion("pui_native_place >=", value, "puiNativePlace");
            return (Criteria) this;
        }

        public Criteria andPuiNativePlaceLessThan(String value) {
            addCriterion("pui_native_place <", value, "puiNativePlace");
            return (Criteria) this;
        }

        public Criteria andPuiNativePlaceLessThanOrEqualTo(String value) {
            addCriterion("pui_native_place <=", value, "puiNativePlace");
            return (Criteria) this;
        }

        public Criteria andPuiNativePlaceLike(String value) {
            addCriterion("pui_native_place like", value, "puiNativePlace");
            return (Criteria) this;
        }

        public Criteria andPuiNativePlaceNotLike(String value) {
            addCriterion("pui_native_place not like", value, "puiNativePlace");
            return (Criteria) this;
        }

        public Criteria andPuiNativePlaceIn(List<String> values) {
            addCriterion("pui_native_place in", values, "puiNativePlace");
            return (Criteria) this;
        }

        public Criteria andPuiNativePlaceNotIn(List<String> values) {
            addCriterion("pui_native_place not in", values, "puiNativePlace");
            return (Criteria) this;
        }

        public Criteria andPuiNativePlaceBetween(String value1, String value2) {
            addCriterion("pui_native_place between", value1, value2, "puiNativePlace");
            return (Criteria) this;
        }

        public Criteria andPuiNativePlaceNotBetween(String value1, String value2) {
            addCriterion("pui_native_place not between", value1, value2, "puiNativePlace");
            return (Criteria) this;
        }

        public Criteria andPuiWorkCityIsNull() {
            addCriterion("pui_work_city is null");
            return (Criteria) this;
        }

        public Criteria andPuiWorkCityIsNotNull() {
            addCriterion("pui_work_city is not null");
            return (Criteria) this;
        }

        public Criteria andPuiWorkCityEqualTo(String value) {
            addCriterion("pui_work_city =", value, "puiWorkCity");
            return (Criteria) this;
        }

        public Criteria andPuiWorkCityNotEqualTo(String value) {
            addCriterion("pui_work_city <>", value, "puiWorkCity");
            return (Criteria) this;
        }

        public Criteria andPuiWorkCityGreaterThan(String value) {
            addCriterion("pui_work_city >", value, "puiWorkCity");
            return (Criteria) this;
        }

        public Criteria andPuiWorkCityGreaterThanOrEqualTo(String value) {
            addCriterion("pui_work_city >=", value, "puiWorkCity");
            return (Criteria) this;
        }

        public Criteria andPuiWorkCityLessThan(String value) {
            addCriterion("pui_work_city <", value, "puiWorkCity");
            return (Criteria) this;
        }

        public Criteria andPuiWorkCityLessThanOrEqualTo(String value) {
            addCriterion("pui_work_city <=", value, "puiWorkCity");
            return (Criteria) this;
        }

        public Criteria andPuiWorkCityLike(String value) {
            addCriterion("pui_work_city like", value, "puiWorkCity");
            return (Criteria) this;
        }

        public Criteria andPuiWorkCityNotLike(String value) {
            addCriterion("pui_work_city not like", value, "puiWorkCity");
            return (Criteria) this;
        }

        public Criteria andPuiWorkCityIn(List<String> values) {
            addCriterion("pui_work_city in", values, "puiWorkCity");
            return (Criteria) this;
        }

        public Criteria andPuiWorkCityNotIn(List<String> values) {
            addCriterion("pui_work_city not in", values, "puiWorkCity");
            return (Criteria) this;
        }

        public Criteria andPuiWorkCityBetween(String value1, String value2) {
            addCriterion("pui_work_city between", value1, value2, "puiWorkCity");
            return (Criteria) this;
        }

        public Criteria andPuiWorkCityNotBetween(String value1, String value2) {
            addCriterion("pui_work_city not between", value1, value2, "puiWorkCity");
            return (Criteria) this;
        }

        public Criteria andPuiWorkProvincesIsNull() {
            addCriterion("pui_work_provinces is null");
            return (Criteria) this;
        }

        public Criteria andPuiWorkProvincesIsNotNull() {
            addCriterion("pui_work_provinces is not null");
            return (Criteria) this;
        }

        public Criteria andPuiWorkProvincesEqualTo(String value) {
            addCriterion("pui_work_provinces =", value, "puiWorkProvinces");
            return (Criteria) this;
        }

        public Criteria andPuiWorkProvincesNotEqualTo(String value) {
            addCriterion("pui_work_provinces <>", value, "puiWorkProvinces");
            return (Criteria) this;
        }

        public Criteria andPuiWorkProvincesGreaterThan(String value) {
            addCriterion("pui_work_provinces >", value, "puiWorkProvinces");
            return (Criteria) this;
        }

        public Criteria andPuiWorkProvincesGreaterThanOrEqualTo(String value) {
            addCriterion("pui_work_provinces >=", value, "puiWorkProvinces");
            return (Criteria) this;
        }

        public Criteria andPuiWorkProvincesLessThan(String value) {
            addCriterion("pui_work_provinces <", value, "puiWorkProvinces");
            return (Criteria) this;
        }

        public Criteria andPuiWorkProvincesLessThanOrEqualTo(String value) {
            addCriterion("pui_work_provinces <=", value, "puiWorkProvinces");
            return (Criteria) this;
        }

        public Criteria andPuiWorkProvincesLike(String value) {
            addCriterion("pui_work_provinces like", value, "puiWorkProvinces");
            return (Criteria) this;
        }

        public Criteria andPuiWorkProvincesNotLike(String value) {
            addCriterion("pui_work_provinces not like", value, "puiWorkProvinces");
            return (Criteria) this;
        }

        public Criteria andPuiWorkProvincesIn(List<String> values) {
            addCriterion("pui_work_provinces in", values, "puiWorkProvinces");
            return (Criteria) this;
        }

        public Criteria andPuiWorkProvincesNotIn(List<String> values) {
            addCriterion("pui_work_provinces not in", values, "puiWorkProvinces");
            return (Criteria) this;
        }

        public Criteria andPuiWorkProvincesBetween(String value1, String value2) {
            addCriterion("pui_work_provinces between", value1, value2, "puiWorkProvinces");
            return (Criteria) this;
        }

        public Criteria andPuiWorkProvincesNotBetween(String value1, String value2) {
            addCriterion("pui_work_provinces not between", value1, value2, "puiWorkProvinces");
            return (Criteria) this;
        }

        public Criteria andPuiWorkAddressIsNull() {
            addCriterion("pui_work_address is null");
            return (Criteria) this;
        }

        public Criteria andPuiWorkAddressIsNotNull() {
            addCriterion("pui_work_address is not null");
            return (Criteria) this;
        }

        public Criteria andPuiWorkAddressEqualTo(String value) {
            addCriterion("pui_work_address =", value, "puiWorkAddress");
            return (Criteria) this;
        }

        public Criteria andPuiWorkAddressNotEqualTo(String value) {
            addCriterion("pui_work_address <>", value, "puiWorkAddress");
            return (Criteria) this;
        }

        public Criteria andPuiWorkAddressGreaterThan(String value) {
            addCriterion("pui_work_address >", value, "puiWorkAddress");
            return (Criteria) this;
        }

        public Criteria andPuiWorkAddressGreaterThanOrEqualTo(String value) {
            addCriterion("pui_work_address >=", value, "puiWorkAddress");
            return (Criteria) this;
        }

        public Criteria andPuiWorkAddressLessThan(String value) {
            addCriterion("pui_work_address <", value, "puiWorkAddress");
            return (Criteria) this;
        }

        public Criteria andPuiWorkAddressLessThanOrEqualTo(String value) {
            addCriterion("pui_work_address <=", value, "puiWorkAddress");
            return (Criteria) this;
        }

        public Criteria andPuiWorkAddressLike(String value) {
            addCriterion("pui_work_address like", value, "puiWorkAddress");
            return (Criteria) this;
        }

        public Criteria andPuiWorkAddressNotLike(String value) {
            addCriterion("pui_work_address not like", value, "puiWorkAddress");
            return (Criteria) this;
        }

        public Criteria andPuiWorkAddressIn(List<String> values) {
            addCriterion("pui_work_address in", values, "puiWorkAddress");
            return (Criteria) this;
        }

        public Criteria andPuiWorkAddressNotIn(List<String> values) {
            addCriterion("pui_work_address not in", values, "puiWorkAddress");
            return (Criteria) this;
        }

        public Criteria andPuiWorkAddressBetween(String value1, String value2) {
            addCriterion("pui_work_address between", value1, value2, "puiWorkAddress");
            return (Criteria) this;
        }

        public Criteria andPuiWorkAddressNotBetween(String value1, String value2) {
            addCriterion("pui_work_address not between", value1, value2, "puiWorkAddress");
            return (Criteria) this;
        }

        public Criteria andPuiCompanyTypeIsNull() {
            addCriterion("pui_company_type is null");
            return (Criteria) this;
        }

        public Criteria andPuiCompanyTypeIsNotNull() {
            addCriterion("pui_company_type is not null");
            return (Criteria) this;
        }

        public Criteria andPuiCompanyTypeEqualTo(String value) {
            addCriterion("pui_company_type =", value, "puiCompanyType");
            return (Criteria) this;
        }

        public Criteria andPuiCompanyTypeNotEqualTo(String value) {
            addCriterion("pui_company_type <>", value, "puiCompanyType");
            return (Criteria) this;
        }

        public Criteria andPuiCompanyTypeGreaterThan(String value) {
            addCriterion("pui_company_type >", value, "puiCompanyType");
            return (Criteria) this;
        }

        public Criteria andPuiCompanyTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pui_company_type >=", value, "puiCompanyType");
            return (Criteria) this;
        }

        public Criteria andPuiCompanyTypeLessThan(String value) {
            addCriterion("pui_company_type <", value, "puiCompanyType");
            return (Criteria) this;
        }

        public Criteria andPuiCompanyTypeLessThanOrEqualTo(String value) {
            addCriterion("pui_company_type <=", value, "puiCompanyType");
            return (Criteria) this;
        }

        public Criteria andPuiCompanyTypeLike(String value) {
            addCriterion("pui_company_type like", value, "puiCompanyType");
            return (Criteria) this;
        }

        public Criteria andPuiCompanyTypeNotLike(String value) {
            addCriterion("pui_company_type not like", value, "puiCompanyType");
            return (Criteria) this;
        }

        public Criteria andPuiCompanyTypeIn(List<String> values) {
            addCriterion("pui_company_type in", values, "puiCompanyType");
            return (Criteria) this;
        }

        public Criteria andPuiCompanyTypeNotIn(List<String> values) {
            addCriterion("pui_company_type not in", values, "puiCompanyType");
            return (Criteria) this;
        }

        public Criteria andPuiCompanyTypeBetween(String value1, String value2) {
            addCriterion("pui_company_type between", value1, value2, "puiCompanyType");
            return (Criteria) this;
        }

        public Criteria andPuiCompanyTypeNotBetween(String value1, String value2) {
            addCriterion("pui_company_type not between", value1, value2, "puiCompanyType");
            return (Criteria) this;
        }

        public Criteria andPuiCompanyIndustryIsNull() {
            addCriterion("pui_company_industry is null");
            return (Criteria) this;
        }

        public Criteria andPuiCompanyIndustryIsNotNull() {
            addCriterion("pui_company_industry is not null");
            return (Criteria) this;
        }

        public Criteria andPuiCompanyIndustryEqualTo(String value) {
            addCriterion("pui_company_industry =", value, "puiCompanyIndustry");
            return (Criteria) this;
        }

        public Criteria andPuiCompanyIndustryNotEqualTo(String value) {
            addCriterion("pui_company_industry <>", value, "puiCompanyIndustry");
            return (Criteria) this;
        }

        public Criteria andPuiCompanyIndustryGreaterThan(String value) {
            addCriterion("pui_company_industry >", value, "puiCompanyIndustry");
            return (Criteria) this;
        }

        public Criteria andPuiCompanyIndustryGreaterThanOrEqualTo(String value) {
            addCriterion("pui_company_industry >=", value, "puiCompanyIndustry");
            return (Criteria) this;
        }

        public Criteria andPuiCompanyIndustryLessThan(String value) {
            addCriterion("pui_company_industry <", value, "puiCompanyIndustry");
            return (Criteria) this;
        }

        public Criteria andPuiCompanyIndustryLessThanOrEqualTo(String value) {
            addCriterion("pui_company_industry <=", value, "puiCompanyIndustry");
            return (Criteria) this;
        }

        public Criteria andPuiCompanyIndustryLike(String value) {
            addCriterion("pui_company_industry like", value, "puiCompanyIndustry");
            return (Criteria) this;
        }

        public Criteria andPuiCompanyIndustryNotLike(String value) {
            addCriterion("pui_company_industry not like", value, "puiCompanyIndustry");
            return (Criteria) this;
        }

        public Criteria andPuiCompanyIndustryIn(List<String> values) {
            addCriterion("pui_company_industry in", values, "puiCompanyIndustry");
            return (Criteria) this;
        }

        public Criteria andPuiCompanyIndustryNotIn(List<String> values) {
            addCriterion("pui_company_industry not in", values, "puiCompanyIndustry");
            return (Criteria) this;
        }

        public Criteria andPuiCompanyIndustryBetween(String value1, String value2) {
            addCriterion("pui_company_industry between", value1, value2, "puiCompanyIndustry");
            return (Criteria) this;
        }

        public Criteria andPuiCompanyIndustryNotBetween(String value1, String value2) {
            addCriterion("pui_company_industry not between", value1, value2, "puiCompanyIndustry");
            return (Criteria) this;
        }

        public Criteria andPuiCompanySizeIsNull() {
            addCriterion("pui_company_size is null");
            return (Criteria) this;
        }

        public Criteria andPuiCompanySizeIsNotNull() {
            addCriterion("pui_company_size is not null");
            return (Criteria) this;
        }

        public Criteria andPuiCompanySizeEqualTo(String value) {
            addCriterion("pui_company_size =", value, "puiCompanySize");
            return (Criteria) this;
        }

        public Criteria andPuiCompanySizeNotEqualTo(String value) {
            addCriterion("pui_company_size <>", value, "puiCompanySize");
            return (Criteria) this;
        }

        public Criteria andPuiCompanySizeGreaterThan(String value) {
            addCriterion("pui_company_size >", value, "puiCompanySize");
            return (Criteria) this;
        }

        public Criteria andPuiCompanySizeGreaterThanOrEqualTo(String value) {
            addCriterion("pui_company_size >=", value, "puiCompanySize");
            return (Criteria) this;
        }

        public Criteria andPuiCompanySizeLessThan(String value) {
            addCriterion("pui_company_size <", value, "puiCompanySize");
            return (Criteria) this;
        }

        public Criteria andPuiCompanySizeLessThanOrEqualTo(String value) {
            addCriterion("pui_company_size <=", value, "puiCompanySize");
            return (Criteria) this;
        }

        public Criteria andPuiCompanySizeLike(String value) {
            addCriterion("pui_company_size like", value, "puiCompanySize");
            return (Criteria) this;
        }

        public Criteria andPuiCompanySizeNotLike(String value) {
            addCriterion("pui_company_size not like", value, "puiCompanySize");
            return (Criteria) this;
        }

        public Criteria andPuiCompanySizeIn(List<String> values) {
            addCriterion("pui_company_size in", values, "puiCompanySize");
            return (Criteria) this;
        }

        public Criteria andPuiCompanySizeNotIn(List<String> values) {
            addCriterion("pui_company_size not in", values, "puiCompanySize");
            return (Criteria) this;
        }

        public Criteria andPuiCompanySizeBetween(String value1, String value2) {
            addCriterion("pui_company_size between", value1, value2, "puiCompanySize");
            return (Criteria) this;
        }

        public Criteria andPuiCompanySizeNotBetween(String value1, String value2) {
            addCriterion("pui_company_size not between", value1, value2, "puiCompanySize");
            return (Criteria) this;
        }

        public Criteria andPuiWorkAgeIsNull() {
            addCriterion("pui_work_age is null");
            return (Criteria) this;
        }

        public Criteria andPuiWorkAgeIsNotNull() {
            addCriterion("pui_work_age is not null");
            return (Criteria) this;
        }

        public Criteria andPuiWorkAgeEqualTo(String value) {
            addCriterion("pui_work_age =", value, "puiWorkAge");
            return (Criteria) this;
        }

        public Criteria andPuiWorkAgeNotEqualTo(String value) {
            addCriterion("pui_work_age <>", value, "puiWorkAge");
            return (Criteria) this;
        }

        public Criteria andPuiWorkAgeGreaterThan(String value) {
            addCriterion("pui_work_age >", value, "puiWorkAge");
            return (Criteria) this;
        }

        public Criteria andPuiWorkAgeGreaterThanOrEqualTo(String value) {
            addCriterion("pui_work_age >=", value, "puiWorkAge");
            return (Criteria) this;
        }

        public Criteria andPuiWorkAgeLessThan(String value) {
            addCriterion("pui_work_age <", value, "puiWorkAge");
            return (Criteria) this;
        }

        public Criteria andPuiWorkAgeLessThanOrEqualTo(String value) {
            addCriterion("pui_work_age <=", value, "puiWorkAge");
            return (Criteria) this;
        }

        public Criteria andPuiWorkAgeLike(String value) {
            addCriterion("pui_work_age like", value, "puiWorkAge");
            return (Criteria) this;
        }

        public Criteria andPuiWorkAgeNotLike(String value) {
            addCriterion("pui_work_age not like", value, "puiWorkAge");
            return (Criteria) this;
        }

        public Criteria andPuiWorkAgeIn(List<String> values) {
            addCriterion("pui_work_age in", values, "puiWorkAge");
            return (Criteria) this;
        }

        public Criteria andPuiWorkAgeNotIn(List<String> values) {
            addCriterion("pui_work_age not in", values, "puiWorkAge");
            return (Criteria) this;
        }

        public Criteria andPuiWorkAgeBetween(String value1, String value2) {
            addCriterion("pui_work_age between", value1, value2, "puiWorkAge");
            return (Criteria) this;
        }

        public Criteria andPuiWorkAgeNotBetween(String value1, String value2) {
            addCriterion("pui_work_age not between", value1, value2, "puiWorkAge");
            return (Criteria) this;
        }

        public Criteria andPuiWorkPhoneIsNull() {
            addCriterion("pui_work_phone is null");
            return (Criteria) this;
        }

        public Criteria andPuiWorkPhoneIsNotNull() {
            addCriterion("pui_work_phone is not null");
            return (Criteria) this;
        }

        public Criteria andPuiWorkPhoneEqualTo(String value) {
            addCriterion("pui_work_phone =", value, "puiWorkPhone");
            return (Criteria) this;
        }

        public Criteria andPuiWorkPhoneNotEqualTo(String value) {
            addCriterion("pui_work_phone <>", value, "puiWorkPhone");
            return (Criteria) this;
        }

        public Criteria andPuiWorkPhoneGreaterThan(String value) {
            addCriterion("pui_work_phone >", value, "puiWorkPhone");
            return (Criteria) this;
        }

        public Criteria andPuiWorkPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("pui_work_phone >=", value, "puiWorkPhone");
            return (Criteria) this;
        }

        public Criteria andPuiWorkPhoneLessThan(String value) {
            addCriterion("pui_work_phone <", value, "puiWorkPhone");
            return (Criteria) this;
        }

        public Criteria andPuiWorkPhoneLessThanOrEqualTo(String value) {
            addCriterion("pui_work_phone <=", value, "puiWorkPhone");
            return (Criteria) this;
        }

        public Criteria andPuiWorkPhoneLike(String value) {
            addCriterion("pui_work_phone like", value, "puiWorkPhone");
            return (Criteria) this;
        }

        public Criteria andPuiWorkPhoneNotLike(String value) {
            addCriterion("pui_work_phone not like", value, "puiWorkPhone");
            return (Criteria) this;
        }

        public Criteria andPuiWorkPhoneIn(List<String> values) {
            addCriterion("pui_work_phone in", values, "puiWorkPhone");
            return (Criteria) this;
        }

        public Criteria andPuiWorkPhoneNotIn(List<String> values) {
            addCriterion("pui_work_phone not in", values, "puiWorkPhone");
            return (Criteria) this;
        }

        public Criteria andPuiWorkPhoneBetween(String value1, String value2) {
            addCriterion("pui_work_phone between", value1, value2, "puiWorkPhone");
            return (Criteria) this;
        }

        public Criteria andPuiWorkPhoneNotBetween(String value1, String value2) {
            addCriterion("pui_work_phone not between", value1, value2, "puiWorkPhone");
            return (Criteria) this;
        }

        public Criteria andPuiWorkPositionIsNull() {
            addCriterion("pui_work_position is null");
            return (Criteria) this;
        }

        public Criteria andPuiWorkPositionIsNotNull() {
            addCriterion("pui_work_position is not null");
            return (Criteria) this;
        }

        public Criteria andPuiWorkPositionEqualTo(String value) {
            addCriterion("pui_work_position =", value, "puiWorkPosition");
            return (Criteria) this;
        }

        public Criteria andPuiWorkPositionNotEqualTo(String value) {
            addCriterion("pui_work_position <>", value, "puiWorkPosition");
            return (Criteria) this;
        }

        public Criteria andPuiWorkPositionGreaterThan(String value) {
            addCriterion("pui_work_position >", value, "puiWorkPosition");
            return (Criteria) this;
        }

        public Criteria andPuiWorkPositionGreaterThanOrEqualTo(String value) {
            addCriterion("pui_work_position >=", value, "puiWorkPosition");
            return (Criteria) this;
        }

        public Criteria andPuiWorkPositionLessThan(String value) {
            addCriterion("pui_work_position <", value, "puiWorkPosition");
            return (Criteria) this;
        }

        public Criteria andPuiWorkPositionLessThanOrEqualTo(String value) {
            addCriterion("pui_work_position <=", value, "puiWorkPosition");
            return (Criteria) this;
        }

        public Criteria andPuiWorkPositionLike(String value) {
            addCriterion("pui_work_position like", value, "puiWorkPosition");
            return (Criteria) this;
        }

        public Criteria andPuiWorkPositionNotLike(String value) {
            addCriterion("pui_work_position not like", value, "puiWorkPosition");
            return (Criteria) this;
        }

        public Criteria andPuiWorkPositionIn(List<String> values) {
            addCriterion("pui_work_position in", values, "puiWorkPosition");
            return (Criteria) this;
        }

        public Criteria andPuiWorkPositionNotIn(List<String> values) {
            addCriterion("pui_work_position not in", values, "puiWorkPosition");
            return (Criteria) this;
        }

        public Criteria andPuiWorkPositionBetween(String value1, String value2) {
            addCriterion("pui_work_position between", value1, value2, "puiWorkPosition");
            return (Criteria) this;
        }

        public Criteria andPuiWorkPositionNotBetween(String value1, String value2) {
            addCriterion("pui_work_position not between", value1, value2, "puiWorkPosition");
            return (Criteria) this;
        }

        public Criteria andPuiMonthSalaryIsNull() {
            addCriterion("pui_month_salary is null");
            return (Criteria) this;
        }

        public Criteria andPuiMonthSalaryIsNotNull() {
            addCriterion("pui_month_salary is not null");
            return (Criteria) this;
        }

        public Criteria andPuiMonthSalaryEqualTo(String value) {
            addCriterion("pui_month_salary =", value, "puiMonthSalary");
            return (Criteria) this;
        }

        public Criteria andPuiMonthSalaryNotEqualTo(String value) {
            addCriterion("pui_month_salary <>", value, "puiMonthSalary");
            return (Criteria) this;
        }

        public Criteria andPuiMonthSalaryGreaterThan(String value) {
            addCriterion("pui_month_salary >", value, "puiMonthSalary");
            return (Criteria) this;
        }

        public Criteria andPuiMonthSalaryGreaterThanOrEqualTo(String value) {
            addCriterion("pui_month_salary >=", value, "puiMonthSalary");
            return (Criteria) this;
        }

        public Criteria andPuiMonthSalaryLessThan(String value) {
            addCriterion("pui_month_salary <", value, "puiMonthSalary");
            return (Criteria) this;
        }

        public Criteria andPuiMonthSalaryLessThanOrEqualTo(String value) {
            addCriterion("pui_month_salary <=", value, "puiMonthSalary");
            return (Criteria) this;
        }

        public Criteria andPuiMonthSalaryLike(String value) {
            addCriterion("pui_month_salary like", value, "puiMonthSalary");
            return (Criteria) this;
        }

        public Criteria andPuiMonthSalaryNotLike(String value) {
            addCriterion("pui_month_salary not like", value, "puiMonthSalary");
            return (Criteria) this;
        }

        public Criteria andPuiMonthSalaryIn(List<String> values) {
            addCriterion("pui_month_salary in", values, "puiMonthSalary");
            return (Criteria) this;
        }

        public Criteria andPuiMonthSalaryNotIn(List<String> values) {
            addCriterion("pui_month_salary not in", values, "puiMonthSalary");
            return (Criteria) this;
        }

        public Criteria andPuiMonthSalaryBetween(String value1, String value2) {
            addCriterion("pui_month_salary between", value1, value2, "puiMonthSalary");
            return (Criteria) this;
        }

        public Criteria andPuiMonthSalaryNotBetween(String value1, String value2) {
            addCriterion("pui_month_salary not between", value1, value2, "puiMonthSalary");
            return (Criteria) this;
        }

        public Criteria andPuiChildrenIsNull() {
            addCriterion("pui_children is null");
            return (Criteria) this;
        }

        public Criteria andPuiChildrenIsNotNull() {
            addCriterion("pui_children is not null");
            return (Criteria) this;
        }

        public Criteria andPuiChildrenEqualTo(String value) {
            addCriterion("pui_children =", value, "puiChildren");
            return (Criteria) this;
        }

        public Criteria andPuiChildrenNotEqualTo(String value) {
            addCriterion("pui_children <>", value, "puiChildren");
            return (Criteria) this;
        }

        public Criteria andPuiChildrenGreaterThan(String value) {
            addCriterion("pui_children >", value, "puiChildren");
            return (Criteria) this;
        }

        public Criteria andPuiChildrenGreaterThanOrEqualTo(String value) {
            addCriterion("pui_children >=", value, "puiChildren");
            return (Criteria) this;
        }

        public Criteria andPuiChildrenLessThan(String value) {
            addCriterion("pui_children <", value, "puiChildren");
            return (Criteria) this;
        }

        public Criteria andPuiChildrenLessThanOrEqualTo(String value) {
            addCriterion("pui_children <=", value, "puiChildren");
            return (Criteria) this;
        }

        public Criteria andPuiChildrenLike(String value) {
            addCriterion("pui_children like", value, "puiChildren");
            return (Criteria) this;
        }

        public Criteria andPuiChildrenNotLike(String value) {
            addCriterion("pui_children not like", value, "puiChildren");
            return (Criteria) this;
        }

        public Criteria andPuiChildrenIn(List<String> values) {
            addCriterion("pui_children in", values, "puiChildren");
            return (Criteria) this;
        }

        public Criteria andPuiChildrenNotIn(List<String> values) {
            addCriterion("pui_children not in", values, "puiChildren");
            return (Criteria) this;
        }

        public Criteria andPuiChildrenBetween(String value1, String value2) {
            addCriterion("pui_children between", value1, value2, "puiChildren");
            return (Criteria) this;
        }

        public Criteria andPuiChildrenNotBetween(String value1, String value2) {
            addCriterion("pui_children not between", value1, value2, "puiChildren");
            return (Criteria) this;
        }

        public Criteria andPuiHouseIsNull() {
            addCriterion("pui_house is null");
            return (Criteria) this;
        }

        public Criteria andPuiHouseIsNotNull() {
            addCriterion("pui_house is not null");
            return (Criteria) this;
        }

        public Criteria andPuiHouseEqualTo(String value) {
            addCriterion("pui_house =", value, "puiHouse");
            return (Criteria) this;
        }

        public Criteria andPuiHouseNotEqualTo(String value) {
            addCriterion("pui_house <>", value, "puiHouse");
            return (Criteria) this;
        }

        public Criteria andPuiHouseGreaterThan(String value) {
            addCriterion("pui_house >", value, "puiHouse");
            return (Criteria) this;
        }

        public Criteria andPuiHouseGreaterThanOrEqualTo(String value) {
            addCriterion("pui_house >=", value, "puiHouse");
            return (Criteria) this;
        }

        public Criteria andPuiHouseLessThan(String value) {
            addCriterion("pui_house <", value, "puiHouse");
            return (Criteria) this;
        }

        public Criteria andPuiHouseLessThanOrEqualTo(String value) {
            addCriterion("pui_house <=", value, "puiHouse");
            return (Criteria) this;
        }

        public Criteria andPuiHouseLike(String value) {
            addCriterion("pui_house like", value, "puiHouse");
            return (Criteria) this;
        }

        public Criteria andPuiHouseNotLike(String value) {
            addCriterion("pui_house not like", value, "puiHouse");
            return (Criteria) this;
        }

        public Criteria andPuiHouseIn(List<String> values) {
            addCriterion("pui_house in", values, "puiHouse");
            return (Criteria) this;
        }

        public Criteria andPuiHouseNotIn(List<String> values) {
            addCriterion("pui_house not in", values, "puiHouse");
            return (Criteria) this;
        }

        public Criteria andPuiHouseBetween(String value1, String value2) {
            addCriterion("pui_house between", value1, value2, "puiHouse");
            return (Criteria) this;
        }

        public Criteria andPuiHouseNotBetween(String value1, String value2) {
            addCriterion("pui_house not between", value1, value2, "puiHouse");
            return (Criteria) this;
        }

        public Criteria andPuiCarsIsNull() {
            addCriterion("pui_cars is null");
            return (Criteria) this;
        }

        public Criteria andPuiCarsIsNotNull() {
            addCriterion("pui_cars is not null");
            return (Criteria) this;
        }

        public Criteria andPuiCarsEqualTo(String value) {
            addCriterion("pui_cars =", value, "puiCars");
            return (Criteria) this;
        }

        public Criteria andPuiCarsNotEqualTo(String value) {
            addCriterion("pui_cars <>", value, "puiCars");
            return (Criteria) this;
        }

        public Criteria andPuiCarsGreaterThan(String value) {
            addCriterion("pui_cars >", value, "puiCars");
            return (Criteria) this;
        }

        public Criteria andPuiCarsGreaterThanOrEqualTo(String value) {
            addCriterion("pui_cars >=", value, "puiCars");
            return (Criteria) this;
        }

        public Criteria andPuiCarsLessThan(String value) {
            addCriterion("pui_cars <", value, "puiCars");
            return (Criteria) this;
        }

        public Criteria andPuiCarsLessThanOrEqualTo(String value) {
            addCriterion("pui_cars <=", value, "puiCars");
            return (Criteria) this;
        }

        public Criteria andPuiCarsLike(String value) {
            addCriterion("pui_cars like", value, "puiCars");
            return (Criteria) this;
        }

        public Criteria andPuiCarsNotLike(String value) {
            addCriterion("pui_cars not like", value, "puiCars");
            return (Criteria) this;
        }

        public Criteria andPuiCarsIn(List<String> values) {
            addCriterion("pui_cars in", values, "puiCars");
            return (Criteria) this;
        }

        public Criteria andPuiCarsNotIn(List<String> values) {
            addCriterion("pui_cars not in", values, "puiCars");
            return (Criteria) this;
        }

        public Criteria andPuiCarsBetween(String value1, String value2) {
            addCriterion("pui_cars between", value1, value2, "puiCars");
            return (Criteria) this;
        }

        public Criteria andPuiCarsNotBetween(String value1, String value2) {
            addCriterion("pui_cars not between", value1, value2, "puiCars");
            return (Criteria) this;
        }

        public Criteria andPuiCarsLoanIsNull() {
            addCriterion("pui_cars_loan is null");
            return (Criteria) this;
        }

        public Criteria andPuiCarsLoanIsNotNull() {
            addCriterion("pui_cars_loan is not null");
            return (Criteria) this;
        }

        public Criteria andPuiCarsLoanEqualTo(String value) {
            addCriterion("pui_cars_loan =", value, "puiCarsLoan");
            return (Criteria) this;
        }

        public Criteria andPuiCarsLoanNotEqualTo(String value) {
            addCriterion("pui_cars_loan <>", value, "puiCarsLoan");
            return (Criteria) this;
        }

        public Criteria andPuiCarsLoanGreaterThan(String value) {
            addCriterion("pui_cars_loan >", value, "puiCarsLoan");
            return (Criteria) this;
        }

        public Criteria andPuiCarsLoanGreaterThanOrEqualTo(String value) {
            addCriterion("pui_cars_loan >=", value, "puiCarsLoan");
            return (Criteria) this;
        }

        public Criteria andPuiCarsLoanLessThan(String value) {
            addCriterion("pui_cars_loan <", value, "puiCarsLoan");
            return (Criteria) this;
        }

        public Criteria andPuiCarsLoanLessThanOrEqualTo(String value) {
            addCriterion("pui_cars_loan <=", value, "puiCarsLoan");
            return (Criteria) this;
        }

        public Criteria andPuiCarsLoanLike(String value) {
            addCriterion("pui_cars_loan like", value, "puiCarsLoan");
            return (Criteria) this;
        }

        public Criteria andPuiCarsLoanNotLike(String value) {
            addCriterion("pui_cars_loan not like", value, "puiCarsLoan");
            return (Criteria) this;
        }

        public Criteria andPuiCarsLoanIn(List<String> values) {
            addCriterion("pui_cars_loan in", values, "puiCarsLoan");
            return (Criteria) this;
        }

        public Criteria andPuiCarsLoanNotIn(List<String> values) {
            addCriterion("pui_cars_loan not in", values, "puiCarsLoan");
            return (Criteria) this;
        }

        public Criteria andPuiCarsLoanBetween(String value1, String value2) {
            addCriterion("pui_cars_loan between", value1, value2, "puiCarsLoan");
            return (Criteria) this;
        }

        public Criteria andPuiCarsLoanNotBetween(String value1, String value2) {
            addCriterion("pui_cars_loan not between", value1, value2, "puiCarsLoan");
            return (Criteria) this;
        }

        public Criteria andPuiHouseLoanIsNull() {
            addCriterion("pui_house_loan is null");
            return (Criteria) this;
        }

        public Criteria andPuiHouseLoanIsNotNull() {
            addCriterion("pui_house_loan is not null");
            return (Criteria) this;
        }

        public Criteria andPuiHouseLoanEqualTo(String value) {
            addCriterion("pui_house_loan =", value, "puiHouseLoan");
            return (Criteria) this;
        }

        public Criteria andPuiHouseLoanNotEqualTo(String value) {
            addCriterion("pui_house_loan <>", value, "puiHouseLoan");
            return (Criteria) this;
        }

        public Criteria andPuiHouseLoanGreaterThan(String value) {
            addCriterion("pui_house_loan >", value, "puiHouseLoan");
            return (Criteria) this;
        }

        public Criteria andPuiHouseLoanGreaterThanOrEqualTo(String value) {
            addCriterion("pui_house_loan >=", value, "puiHouseLoan");
            return (Criteria) this;
        }

        public Criteria andPuiHouseLoanLessThan(String value) {
            addCriterion("pui_house_loan <", value, "puiHouseLoan");
            return (Criteria) this;
        }

        public Criteria andPuiHouseLoanLessThanOrEqualTo(String value) {
            addCriterion("pui_house_loan <=", value, "puiHouseLoan");
            return (Criteria) this;
        }

        public Criteria andPuiHouseLoanLike(String value) {
            addCriterion("pui_house_loan like", value, "puiHouseLoan");
            return (Criteria) this;
        }

        public Criteria andPuiHouseLoanNotLike(String value) {
            addCriterion("pui_house_loan not like", value, "puiHouseLoan");
            return (Criteria) this;
        }

        public Criteria andPuiHouseLoanIn(List<String> values) {
            addCriterion("pui_house_loan in", values, "puiHouseLoan");
            return (Criteria) this;
        }

        public Criteria andPuiHouseLoanNotIn(List<String> values) {
            addCriterion("pui_house_loan not in", values, "puiHouseLoan");
            return (Criteria) this;
        }

        public Criteria andPuiHouseLoanBetween(String value1, String value2) {
            addCriterion("pui_house_loan between", value1, value2, "puiHouseLoan");
            return (Criteria) this;
        }

        public Criteria andPuiHouseLoanNotBetween(String value1, String value2) {
            addCriterion("pui_house_loan not between", value1, value2, "puiHouseLoan");
            return (Criteria) this;
        }

        public Criteria andPuiRelativeNameIsNull() {
            addCriterion("pui_relative_name is null");
            return (Criteria) this;
        }

        public Criteria andPuiRelativeNameIsNotNull() {
            addCriterion("pui_relative_name is not null");
            return (Criteria) this;
        }

        public Criteria andPuiRelativeNameEqualTo(String value) {
            addCriterion("pui_relative_name =", value, "puiRelativeName");
            return (Criteria) this;
        }

        public Criteria andPuiRelativeNameNotEqualTo(String value) {
            addCriterion("pui_relative_name <>", value, "puiRelativeName");
            return (Criteria) this;
        }

        public Criteria andPuiRelativeNameGreaterThan(String value) {
            addCriterion("pui_relative_name >", value, "puiRelativeName");
            return (Criteria) this;
        }

        public Criteria andPuiRelativeNameGreaterThanOrEqualTo(String value) {
            addCriterion("pui_relative_name >=", value, "puiRelativeName");
            return (Criteria) this;
        }

        public Criteria andPuiRelativeNameLessThan(String value) {
            addCriterion("pui_relative_name <", value, "puiRelativeName");
            return (Criteria) this;
        }

        public Criteria andPuiRelativeNameLessThanOrEqualTo(String value) {
            addCriterion("pui_relative_name <=", value, "puiRelativeName");
            return (Criteria) this;
        }

        public Criteria andPuiRelativeNameLike(String value) {
            addCriterion("pui_relative_name like", value, "puiRelativeName");
            return (Criteria) this;
        }

        public Criteria andPuiRelativeNameNotLike(String value) {
            addCriterion("pui_relative_name not like", value, "puiRelativeName");
            return (Criteria) this;
        }

        public Criteria andPuiRelativeNameIn(List<String> values) {
            addCriterion("pui_relative_name in", values, "puiRelativeName");
            return (Criteria) this;
        }

        public Criteria andPuiRelativeNameNotIn(List<String> values) {
            addCriterion("pui_relative_name not in", values, "puiRelativeName");
            return (Criteria) this;
        }

        public Criteria andPuiRelativeNameBetween(String value1, String value2) {
            addCriterion("pui_relative_name between", value1, value2, "puiRelativeName");
            return (Criteria) this;
        }

        public Criteria andPuiRelativeNameNotBetween(String value1, String value2) {
            addCriterion("pui_relative_name not between", value1, value2, "puiRelativeName");
            return (Criteria) this;
        }

        public Criteria andPuiRelativeRelationIsNull() {
            addCriterion("pui_relative_relation is null");
            return (Criteria) this;
        }

        public Criteria andPuiRelativeRelationIsNotNull() {
            addCriterion("pui_relative_relation is not null");
            return (Criteria) this;
        }

        public Criteria andPuiRelativeRelationEqualTo(String value) {
            addCriterion("pui_relative_relation =", value, "puiRelativeRelation");
            return (Criteria) this;
        }

        public Criteria andPuiRelativeRelationNotEqualTo(String value) {
            addCriterion("pui_relative_relation <>", value, "puiRelativeRelation");
            return (Criteria) this;
        }

        public Criteria andPuiRelativeRelationGreaterThan(String value) {
            addCriterion("pui_relative_relation >", value, "puiRelativeRelation");
            return (Criteria) this;
        }

        public Criteria andPuiRelativeRelationGreaterThanOrEqualTo(String value) {
            addCriterion("pui_relative_relation >=", value, "puiRelativeRelation");
            return (Criteria) this;
        }

        public Criteria andPuiRelativeRelationLessThan(String value) {
            addCriterion("pui_relative_relation <", value, "puiRelativeRelation");
            return (Criteria) this;
        }

        public Criteria andPuiRelativeRelationLessThanOrEqualTo(String value) {
            addCriterion("pui_relative_relation <=", value, "puiRelativeRelation");
            return (Criteria) this;
        }

        public Criteria andPuiRelativeRelationLike(String value) {
            addCriterion("pui_relative_relation like", value, "puiRelativeRelation");
            return (Criteria) this;
        }

        public Criteria andPuiRelativeRelationNotLike(String value) {
            addCriterion("pui_relative_relation not like", value, "puiRelativeRelation");
            return (Criteria) this;
        }

        public Criteria andPuiRelativeRelationIn(List<String> values) {
            addCriterion("pui_relative_relation in", values, "puiRelativeRelation");
            return (Criteria) this;
        }

        public Criteria andPuiRelativeRelationNotIn(List<String> values) {
            addCriterion("pui_relative_relation not in", values, "puiRelativeRelation");
            return (Criteria) this;
        }

        public Criteria andPuiRelativeRelationBetween(String value1, String value2) {
            addCriterion("pui_relative_relation between", value1, value2, "puiRelativeRelation");
            return (Criteria) this;
        }

        public Criteria andPuiRelativeRelationNotBetween(String value1, String value2) {
            addCriterion("pui_relative_relation not between", value1, value2, "puiRelativeRelation");
            return (Criteria) this;
        }

        public Criteria andPuiRelativePhoneIsNull() {
            addCriterion("pui_relative_phone is null");
            return (Criteria) this;
        }

        public Criteria andPuiRelativePhoneIsNotNull() {
            addCriterion("pui_relative_phone is not null");
            return (Criteria) this;
        }

        public Criteria andPuiRelativePhoneEqualTo(String value) {
            addCriterion("pui_relative_phone =", value, "puiRelativePhone");
            return (Criteria) this;
        }

        public Criteria andPuiRelativePhoneNotEqualTo(String value) {
            addCriterion("pui_relative_phone <>", value, "puiRelativePhone");
            return (Criteria) this;
        }

        public Criteria andPuiRelativePhoneGreaterThan(String value) {
            addCriterion("pui_relative_phone >", value, "puiRelativePhone");
            return (Criteria) this;
        }

        public Criteria andPuiRelativePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("pui_relative_phone >=", value, "puiRelativePhone");
            return (Criteria) this;
        }

        public Criteria andPuiRelativePhoneLessThan(String value) {
            addCriterion("pui_relative_phone <", value, "puiRelativePhone");
            return (Criteria) this;
        }

        public Criteria andPuiRelativePhoneLessThanOrEqualTo(String value) {
            addCriterion("pui_relative_phone <=", value, "puiRelativePhone");
            return (Criteria) this;
        }

        public Criteria andPuiRelativePhoneLike(String value) {
            addCriterion("pui_relative_phone like", value, "puiRelativePhone");
            return (Criteria) this;
        }

        public Criteria andPuiRelativePhoneNotLike(String value) {
            addCriterion("pui_relative_phone not like", value, "puiRelativePhone");
            return (Criteria) this;
        }

        public Criteria andPuiRelativePhoneIn(List<String> values) {
            addCriterion("pui_relative_phone in", values, "puiRelativePhone");
            return (Criteria) this;
        }

        public Criteria andPuiRelativePhoneNotIn(List<String> values) {
            addCriterion("pui_relative_phone not in", values, "puiRelativePhone");
            return (Criteria) this;
        }

        public Criteria andPuiRelativePhoneBetween(String value1, String value2) {
            addCriterion("pui_relative_phone between", value1, value2, "puiRelativePhone");
            return (Criteria) this;
        }

        public Criteria andPuiRelativePhoneNotBetween(String value1, String value2) {
            addCriterion("pui_relative_phone not between", value1, value2, "puiRelativePhone");
            return (Criteria) this;
        }

        public Criteria andPuiContactNameIsNull() {
            addCriterion("pui_contact_name is null");
            return (Criteria) this;
        }

        public Criteria andPuiContactNameIsNotNull() {
            addCriterion("pui_contact_name is not null");
            return (Criteria) this;
        }

        public Criteria andPuiContactNameEqualTo(String value) {
            addCriterion("pui_contact_name =", value, "puiContactName");
            return (Criteria) this;
        }

        public Criteria andPuiContactNameNotEqualTo(String value) {
            addCriterion("pui_contact_name <>", value, "puiContactName");
            return (Criteria) this;
        }

        public Criteria andPuiContactNameGreaterThan(String value) {
            addCriterion("pui_contact_name >", value, "puiContactName");
            return (Criteria) this;
        }

        public Criteria andPuiContactNameGreaterThanOrEqualTo(String value) {
            addCriterion("pui_contact_name >=", value, "puiContactName");
            return (Criteria) this;
        }

        public Criteria andPuiContactNameLessThan(String value) {
            addCriterion("pui_contact_name <", value, "puiContactName");
            return (Criteria) this;
        }

        public Criteria andPuiContactNameLessThanOrEqualTo(String value) {
            addCriterion("pui_contact_name <=", value, "puiContactName");
            return (Criteria) this;
        }

        public Criteria andPuiContactNameLike(String value) {
            addCriterion("pui_contact_name like", value, "puiContactName");
            return (Criteria) this;
        }

        public Criteria andPuiContactNameNotLike(String value) {
            addCriterion("pui_contact_name not like", value, "puiContactName");
            return (Criteria) this;
        }

        public Criteria andPuiContactNameIn(List<String> values) {
            addCriterion("pui_contact_name in", values, "puiContactName");
            return (Criteria) this;
        }

        public Criteria andPuiContactNameNotIn(List<String> values) {
            addCriterion("pui_contact_name not in", values, "puiContactName");
            return (Criteria) this;
        }

        public Criteria andPuiContactNameBetween(String value1, String value2) {
            addCriterion("pui_contact_name between", value1, value2, "puiContactName");
            return (Criteria) this;
        }

        public Criteria andPuiContactNameNotBetween(String value1, String value2) {
            addCriterion("pui_contact_name not between", value1, value2, "puiContactName");
            return (Criteria) this;
        }

        public Criteria andPuiContactRelationIsNull() {
            addCriterion("pui_contact_relation is null");
            return (Criteria) this;
        }

        public Criteria andPuiContactRelationIsNotNull() {
            addCriterion("pui_contact_relation is not null");
            return (Criteria) this;
        }

        public Criteria andPuiContactRelationEqualTo(String value) {
            addCriterion("pui_contact_relation =", value, "puiContactRelation");
            return (Criteria) this;
        }

        public Criteria andPuiContactRelationNotEqualTo(String value) {
            addCriterion("pui_contact_relation <>", value, "puiContactRelation");
            return (Criteria) this;
        }

        public Criteria andPuiContactRelationGreaterThan(String value) {
            addCriterion("pui_contact_relation >", value, "puiContactRelation");
            return (Criteria) this;
        }

        public Criteria andPuiContactRelationGreaterThanOrEqualTo(String value) {
            addCriterion("pui_contact_relation >=", value, "puiContactRelation");
            return (Criteria) this;
        }

        public Criteria andPuiContactRelationLessThan(String value) {
            addCriterion("pui_contact_relation <", value, "puiContactRelation");
            return (Criteria) this;
        }

        public Criteria andPuiContactRelationLessThanOrEqualTo(String value) {
            addCriterion("pui_contact_relation <=", value, "puiContactRelation");
            return (Criteria) this;
        }

        public Criteria andPuiContactRelationLike(String value) {
            addCriterion("pui_contact_relation like", value, "puiContactRelation");
            return (Criteria) this;
        }

        public Criteria andPuiContactRelationNotLike(String value) {
            addCriterion("pui_contact_relation not like", value, "puiContactRelation");
            return (Criteria) this;
        }

        public Criteria andPuiContactRelationIn(List<String> values) {
            addCriterion("pui_contact_relation in", values, "puiContactRelation");
            return (Criteria) this;
        }

        public Criteria andPuiContactRelationNotIn(List<String> values) {
            addCriterion("pui_contact_relation not in", values, "puiContactRelation");
            return (Criteria) this;
        }

        public Criteria andPuiContactRelationBetween(String value1, String value2) {
            addCriterion("pui_contact_relation between", value1, value2, "puiContactRelation");
            return (Criteria) this;
        }

        public Criteria andPuiContactRelationNotBetween(String value1, String value2) {
            addCriterion("pui_contact_relation not between", value1, value2, "puiContactRelation");
            return (Criteria) this;
        }

        public Criteria andPuiContactPhoneIsNull() {
            addCriterion("pui_contact_phone is null");
            return (Criteria) this;
        }

        public Criteria andPuiContactPhoneIsNotNull() {
            addCriterion("pui_contact_phone is not null");
            return (Criteria) this;
        }

        public Criteria andPuiContactPhoneEqualTo(String value) {
            addCriterion("pui_contact_phone =", value, "puiContactPhone");
            return (Criteria) this;
        }

        public Criteria andPuiContactPhoneNotEqualTo(String value) {
            addCriterion("pui_contact_phone <>", value, "puiContactPhone");
            return (Criteria) this;
        }

        public Criteria andPuiContactPhoneGreaterThan(String value) {
            addCriterion("pui_contact_phone >", value, "puiContactPhone");
            return (Criteria) this;
        }

        public Criteria andPuiContactPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("pui_contact_phone >=", value, "puiContactPhone");
            return (Criteria) this;
        }

        public Criteria andPuiContactPhoneLessThan(String value) {
            addCriterion("pui_contact_phone <", value, "puiContactPhone");
            return (Criteria) this;
        }

        public Criteria andPuiContactPhoneLessThanOrEqualTo(String value) {
            addCriterion("pui_contact_phone <=", value, "puiContactPhone");
            return (Criteria) this;
        }

        public Criteria andPuiContactPhoneLike(String value) {
            addCriterion("pui_contact_phone like", value, "puiContactPhone");
            return (Criteria) this;
        }

        public Criteria andPuiContactPhoneNotLike(String value) {
            addCriterion("pui_contact_phone not like", value, "puiContactPhone");
            return (Criteria) this;
        }

        public Criteria andPuiContactPhoneIn(List<String> values) {
            addCriterion("pui_contact_phone in", values, "puiContactPhone");
            return (Criteria) this;
        }

        public Criteria andPuiContactPhoneNotIn(List<String> values) {
            addCriterion("pui_contact_phone not in", values, "puiContactPhone");
            return (Criteria) this;
        }

        public Criteria andPuiContactPhoneBetween(String value1, String value2) {
            addCriterion("pui_contact_phone between", value1, value2, "puiContactPhone");
            return (Criteria) this;
        }

        public Criteria andPuiContactPhoneNotBetween(String value1, String value2) {
            addCriterion("pui_contact_phone not between", value1, value2, "puiContactPhone");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}