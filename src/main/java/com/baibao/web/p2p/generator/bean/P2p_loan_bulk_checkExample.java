package com.baibao.web.p2p.generator.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class P2p_loan_bulk_checkExample implements Serializable{
    
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public P2p_loan_bulk_checkExample() {
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

        public Criteria andPlbcCheckidIsNull() {
            addCriterion("plbc_checkId is null");
            return (Criteria) this;
        }

        public Criteria andPlbcCheckidIsNotNull() {
            addCriterion("plbc_checkId is not null");
            return (Criteria) this;
        }

        public Criteria andPlbcCheckidEqualTo(Long value) {
            addCriterion("plbc_checkId =", value, "plbcCheckid");
            return (Criteria) this;
        }

        public Criteria andPlbcCheckidNotEqualTo(Long value) {
            addCriterion("plbc_checkId <>", value, "plbcCheckid");
            return (Criteria) this;
        }

        public Criteria andPlbcCheckidGreaterThan(Long value) {
            addCriterion("plbc_checkId >", value, "plbcCheckid");
            return (Criteria) this;
        }

        public Criteria andPlbcCheckidGreaterThanOrEqualTo(Long value) {
            addCriterion("plbc_checkId >=", value, "plbcCheckid");
            return (Criteria) this;
        }

        public Criteria andPlbcCheckidLessThan(Long value) {
            addCriterion("plbc_checkId <", value, "plbcCheckid");
            return (Criteria) this;
        }

        public Criteria andPlbcCheckidLessThanOrEqualTo(Long value) {
            addCriterion("plbc_checkId <=", value, "plbcCheckid");
            return (Criteria) this;
        }

        public Criteria andPlbcCheckidIn(List<Long> values) {
            addCriterion("plbc_checkId in", values, "plbcCheckid");
            return (Criteria) this;
        }

        public Criteria andPlbcCheckidNotIn(List<Long> values) {
            addCriterion("plbc_checkId not in", values, "plbcCheckid");
            return (Criteria) this;
        }

        public Criteria andPlbcCheckidBetween(Long value1, Long value2) {
            addCriterion("plbc_checkId between", value1, value2, "plbcCheckid");
            return (Criteria) this;
        }

        public Criteria andPlbcCheckidNotBetween(Long value1, Long value2) {
            addCriterion("plbc_checkId not between", value1, value2, "plbcCheckid");
            return (Criteria) this;
        }

        public Criteria andPlbcProductidIsNull() {
            addCriterion("plbc_productId is null");
            return (Criteria) this;
        }

        public Criteria andPlbcProductidIsNotNull() {
            addCriterion("plbc_productId is not null");
            return (Criteria) this;
        }

        public Criteria andPlbcProductidEqualTo(Long value) {
            addCriterion("plbc_productId =", value, "plbcProductid");
            return (Criteria) this;
        }

        public Criteria andPlbcProductidNotEqualTo(Long value) {
            addCriterion("plbc_productId <>", value, "plbcProductid");
            return (Criteria) this;
        }

        public Criteria andPlbcProductidGreaterThan(Long value) {
            addCriterion("plbc_productId >", value, "plbcProductid");
            return (Criteria) this;
        }

        public Criteria andPlbcProductidGreaterThanOrEqualTo(Long value) {
            addCriterion("plbc_productId >=", value, "plbcProductid");
            return (Criteria) this;
        }

        public Criteria andPlbcProductidLessThan(Long value) {
            addCriterion("plbc_productId <", value, "plbcProductid");
            return (Criteria) this;
        }

        public Criteria andPlbcProductidLessThanOrEqualTo(Long value) {
            addCriterion("plbc_productId <=", value, "plbcProductid");
            return (Criteria) this;
        }

        public Criteria andPlbcProductidIn(List<Long> values) {
            addCriterion("plbc_productId in", values, "plbcProductid");
            return (Criteria) this;
        }

        public Criteria andPlbcProductidNotIn(List<Long> values) {
            addCriterion("plbc_productId not in", values, "plbcProductid");
            return (Criteria) this;
        }

        public Criteria andPlbcProductidBetween(Long value1, Long value2) {
            addCriterion("plbc_productId between", value1, value2, "plbcProductid");
            return (Criteria) this;
        }

        public Criteria andPlbcProductidNotBetween(Long value1, Long value2) {
            addCriterion("plbc_productId not between", value1, value2, "plbcProductid");
            return (Criteria) this;
        }

        public Criteria andPlbcEmployeenoIsNull() {
            addCriterion("plbc_employeeNo is null");
            return (Criteria) this;
        }

        public Criteria andPlbcEmployeenoIsNotNull() {
            addCriterion("plbc_employeeNo is not null");
            return (Criteria) this;
        }

        public Criteria andPlbcEmployeenoEqualTo(String value) {
            addCriterion("plbc_employeeNo =", value, "plbcEmployeeno");
            return (Criteria) this;
        }

        public Criteria andPlbcEmployeenoNotEqualTo(String value) {
            addCriterion("plbc_employeeNo <>", value, "plbcEmployeeno");
            return (Criteria) this;
        }

        public Criteria andPlbcEmployeenoGreaterThan(String value) {
            addCriterion("plbc_employeeNo >", value, "plbcEmployeeno");
            return (Criteria) this;
        }

        public Criteria andPlbcEmployeenoGreaterThanOrEqualTo(String value) {
            addCriterion("plbc_employeeNo >=", value, "plbcEmployeeno");
            return (Criteria) this;
        }

        public Criteria andPlbcEmployeenoLessThan(String value) {
            addCriterion("plbc_employeeNo <", value, "plbcEmployeeno");
            return (Criteria) this;
        }

        public Criteria andPlbcEmployeenoLessThanOrEqualTo(String value) {
            addCriterion("plbc_employeeNo <=", value, "plbcEmployeeno");
            return (Criteria) this;
        }

        public Criteria andPlbcEmployeenoLike(String value) {
            addCriterion("plbc_employeeNo like", value, "plbcEmployeeno");
            return (Criteria) this;
        }

        public Criteria andPlbcEmployeenoNotLike(String value) {
            addCriterion("plbc_employeeNo not like", value, "plbcEmployeeno");
            return (Criteria) this;
        }

        public Criteria andPlbcEmployeenoIn(List<String> values) {
            addCriterion("plbc_employeeNo in", values, "plbcEmployeeno");
            return (Criteria) this;
        }

        public Criteria andPlbcEmployeenoNotIn(List<String> values) {
            addCriterion("plbc_employeeNo not in", values, "plbcEmployeeno");
            return (Criteria) this;
        }

        public Criteria andPlbcEmployeenoBetween(String value1, String value2) {
            addCriterion("plbc_employeeNo between", value1, value2, "plbcEmployeeno");
            return (Criteria) this;
        }

        public Criteria andPlbcEmployeenoNotBetween(String value1, String value2) {
            addCriterion("plbc_employeeNo not between", value1, value2, "plbcEmployeeno");
            return (Criteria) this;
        }

        public Criteria andPlbcExaminedatetimeIsNull() {
            addCriterion("plbc_examinedatetime is null");
            return (Criteria) this;
        }

        public Criteria andPlbcExaminedatetimeIsNotNull() {
            addCriterion("plbc_examinedatetime is not null");
            return (Criteria) this;
        }

        public Criteria andPlbcExaminedatetimeEqualTo(Date value) {
            addCriterion("plbc_examinedatetime =", value, "plbcExaminedatetime");
            return (Criteria) this;
        }

        public Criteria andPlbcExaminedatetimeNotEqualTo(Date value) {
            addCriterion("plbc_examinedatetime <>", value, "plbcExaminedatetime");
            return (Criteria) this;
        }

        public Criteria andPlbcExaminedatetimeGreaterThan(Date value) {
            addCriterion("plbc_examinedatetime >", value, "plbcExaminedatetime");
            return (Criteria) this;
        }

        public Criteria andPlbcExaminedatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("plbc_examinedatetime >=", value, "plbcExaminedatetime");
            return (Criteria) this;
        }

        public Criteria andPlbcExaminedatetimeLessThan(Date value) {
            addCriterion("plbc_examinedatetime <", value, "plbcExaminedatetime");
            return (Criteria) this;
        }

        public Criteria andPlbcExaminedatetimeLessThanOrEqualTo(Date value) {
            addCriterion("plbc_examinedatetime <=", value, "plbcExaminedatetime");
            return (Criteria) this;
        }

        public Criteria andPlbcExaminedatetimeIn(List<Date> values) {
            addCriterion("plbc_examinedatetime in", values, "plbcExaminedatetime");
            return (Criteria) this;
        }

        public Criteria andPlbcExaminedatetimeNotIn(List<Date> values) {
            addCriterion("plbc_examinedatetime not in", values, "plbcExaminedatetime");
            return (Criteria) this;
        }

        public Criteria andPlbcExaminedatetimeBetween(Date value1, Date value2) {
            addCriterion("plbc_examinedatetime between", value1, value2, "plbcExaminedatetime");
            return (Criteria) this;
        }

        public Criteria andPlbcExaminedatetimeNotBetween(Date value1, Date value2) {
            addCriterion("plbc_examinedatetime not between", value1, value2, "plbcExaminedatetime");
            return (Criteria) this;
        }

        public Criteria andPlbcExaminetypeIsNull() {
            addCriterion("plbc_examineType is null");
            return (Criteria) this;
        }

        public Criteria andPlbcExaminetypeIsNotNull() {
            addCriterion("plbc_examineType is not null");
            return (Criteria) this;
        }

        public Criteria andPlbcExaminetypeEqualTo(String value) {
            addCriterion("plbc_examineType =", value, "plbcExaminetype");
            return (Criteria) this;
        }

        public Criteria andPlbcExaminetypeNotEqualTo(String value) {
            addCriterion("plbc_examineType <>", value, "plbcExaminetype");
            return (Criteria) this;
        }

        public Criteria andPlbcExaminetypeGreaterThan(String value) {
            addCriterion("plbc_examineType >", value, "plbcExaminetype");
            return (Criteria) this;
        }

        public Criteria andPlbcExaminetypeGreaterThanOrEqualTo(String value) {
            addCriterion("plbc_examineType >=", value, "plbcExaminetype");
            return (Criteria) this;
        }

        public Criteria andPlbcExaminetypeLessThan(String value) {
            addCriterion("plbc_examineType <", value, "plbcExaminetype");
            return (Criteria) this;
        }

        public Criteria andPlbcExaminetypeLessThanOrEqualTo(String value) {
            addCriterion("plbc_examineType <=", value, "plbcExaminetype");
            return (Criteria) this;
        }

        public Criteria andPlbcExaminetypeLike(String value) {
            addCriterion("plbc_examineType like", value, "plbcExaminetype");
            return (Criteria) this;
        }

        public Criteria andPlbcExaminetypeNotLike(String value) {
            addCriterion("plbc_examineType not like", value, "plbcExaminetype");
            return (Criteria) this;
        }

        public Criteria andPlbcExaminetypeIn(List<String> values) {
            addCriterion("plbc_examineType in", values, "plbcExaminetype");
            return (Criteria) this;
        }

        public Criteria andPlbcExaminetypeNotIn(List<String> values) {
            addCriterion("plbc_examineType not in", values, "plbcExaminetype");
            return (Criteria) this;
        }

        public Criteria andPlbcExaminetypeBetween(String value1, String value2) {
            addCriterion("plbc_examineType between", value1, value2, "plbcExaminetype");
            return (Criteria) this;
        }

        public Criteria andPlbcExaminetypeNotBetween(String value1, String value2) {
            addCriterion("plbc_examineType not between", value1, value2, "plbcExaminetype");
            return (Criteria) this;
        }

        public Criteria andPlbcExaminestateIsNull() {
            addCriterion("plbc_examineState is null");
            return (Criteria) this;
        }

        public Criteria andPlbcExaminestateIsNotNull() {
            addCriterion("plbc_examineState is not null");
            return (Criteria) this;
        }

        public Criteria andPlbcExaminestateEqualTo(String value) {
            addCriterion("plbc_examineState =", value, "plbcExaminestate");
            return (Criteria) this;
        }

        public Criteria andPlbcExaminestateNotEqualTo(String value) {
            addCriterion("plbc_examineState <>", value, "plbcExaminestate");
            return (Criteria) this;
        }

        public Criteria andPlbcExaminestateGreaterThan(String value) {
            addCriterion("plbc_examineState >", value, "plbcExaminestate");
            return (Criteria) this;
        }

        public Criteria andPlbcExaminestateGreaterThanOrEqualTo(String value) {
            addCriterion("plbc_examineState >=", value, "plbcExaminestate");
            return (Criteria) this;
        }

        public Criteria andPlbcExaminestateLessThan(String value) {
            addCriterion("plbc_examineState <", value, "plbcExaminestate");
            return (Criteria) this;
        }

        public Criteria andPlbcExaminestateLessThanOrEqualTo(String value) {
            addCriterion("plbc_examineState <=", value, "plbcExaminestate");
            return (Criteria) this;
        }

        public Criteria andPlbcExaminestateLike(String value) {
            addCriterion("plbc_examineState like", value, "plbcExaminestate");
            return (Criteria) this;
        }

        public Criteria andPlbcExaminestateNotLike(String value) {
            addCriterion("plbc_examineState not like", value, "plbcExaminestate");
            return (Criteria) this;
        }

        public Criteria andPlbcExaminestateIn(List<String> values) {
            addCriterion("plbc_examineState in", values, "plbcExaminestate");
            return (Criteria) this;
        }

        public Criteria andPlbcExaminestateNotIn(List<String> values) {
            addCriterion("plbc_examineState not in", values, "plbcExaminestate");
            return (Criteria) this;
        }

        public Criteria andPlbcExaminestateBetween(String value1, String value2) {
            addCriterion("plbc_examineState between", value1, value2, "plbcExaminestate");
            return (Criteria) this;
        }

        public Criteria andPlbcExaminestateNotBetween(String value1, String value2) {
            addCriterion("plbc_examineState not between", value1, value2, "plbcExaminestate");
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