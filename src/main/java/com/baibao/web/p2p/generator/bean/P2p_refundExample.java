package com.baibao.web.p2p.generator.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class P2p_refundExample implements Serializable{
    
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public P2p_refundExample() {
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

        public Criteria andPrIdIsNull() {
            addCriterion("pr_id is null");
            return (Criteria) this;
        }

        public Criteria andPrIdIsNotNull() {
            addCriterion("pr_id is not null");
            return (Criteria) this;
        }

        public Criteria andPrIdEqualTo(Long value) {
            addCriterion("pr_id =", value, "prId");
            return (Criteria) this;
        }

        public Criteria andPrIdNotEqualTo(Long value) {
            addCriterion("pr_id <>", value, "prId");
            return (Criteria) this;
        }

        public Criteria andPrIdGreaterThan(Long value) {
            addCriterion("pr_id >", value, "prId");
            return (Criteria) this;
        }

        public Criteria andPrIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pr_id >=", value, "prId");
            return (Criteria) this;
        }

        public Criteria andPrIdLessThan(Long value) {
            addCriterion("pr_id <", value, "prId");
            return (Criteria) this;
        }

        public Criteria andPrIdLessThanOrEqualTo(Long value) {
            addCriterion("pr_id <=", value, "prId");
            return (Criteria) this;
        }

        public Criteria andPrIdIn(List<Long> values) {
            addCriterion("pr_id in", values, "prId");
            return (Criteria) this;
        }

        public Criteria andPrIdNotIn(List<Long> values) {
            addCriterion("pr_id not in", values, "prId");
            return (Criteria) this;
        }

        public Criteria andPrIdBetween(Long value1, Long value2) {
            addCriterion("pr_id between", value1, value2, "prId");
            return (Criteria) this;
        }

        public Criteria andPrIdNotBetween(Long value1, Long value2) {
            addCriterion("pr_id not between", value1, value2, "prId");
            return (Criteria) this;
        }

        public Criteria andPrFefundflownoIsNull() {
            addCriterion("pr_fefundFlowNo is null");
            return (Criteria) this;
        }

        public Criteria andPrFefundflownoIsNotNull() {
            addCriterion("pr_fefundFlowNo is not null");
            return (Criteria) this;
        }

        public Criteria andPrFefundflownoEqualTo(String value) {
            addCriterion("pr_fefundFlowNo =", value, "prFefundflowno");
            return (Criteria) this;
        }

        public Criteria andPrFefundflownoNotEqualTo(String value) {
            addCriterion("pr_fefundFlowNo <>", value, "prFefundflowno");
            return (Criteria) this;
        }

        public Criteria andPrFefundflownoGreaterThan(String value) {
            addCriterion("pr_fefundFlowNo >", value, "prFefundflowno");
            return (Criteria) this;
        }

        public Criteria andPrFefundflownoGreaterThanOrEqualTo(String value) {
            addCriterion("pr_fefundFlowNo >=", value, "prFefundflowno");
            return (Criteria) this;
        }

        public Criteria andPrFefundflownoLessThan(String value) {
            addCriterion("pr_fefundFlowNo <", value, "prFefundflowno");
            return (Criteria) this;
        }

        public Criteria andPrFefundflownoLessThanOrEqualTo(String value) {
            addCriterion("pr_fefundFlowNo <=", value, "prFefundflowno");
            return (Criteria) this;
        }

        public Criteria andPrFefundflownoLike(String value) {
            addCriterion("pr_fefundFlowNo like", value, "prFefundflowno");
            return (Criteria) this;
        }

        public Criteria andPrFefundflownoNotLike(String value) {
            addCriterion("pr_fefundFlowNo not like", value, "prFefundflowno");
            return (Criteria) this;
        }

        public Criteria andPrFefundflownoIn(List<String> values) {
            addCriterion("pr_fefundFlowNo in", values, "prFefundflowno");
            return (Criteria) this;
        }

        public Criteria andPrFefundflownoNotIn(List<String> values) {
            addCriterion("pr_fefundFlowNo not in", values, "prFefundflowno");
            return (Criteria) this;
        }

        public Criteria andPrFefundflownoBetween(String value1, String value2) {
            addCriterion("pr_fefundFlowNo between", value1, value2, "prFefundflowno");
            return (Criteria) this;
        }

        public Criteria andPrFefundflownoNotBetween(String value1, String value2) {
            addCriterion("pr_fefundFlowNo not between", value1, value2, "prFefundflowno");
            return (Criteria) this;
        }

        public Criteria andPrFefundtypeIsNull() {
            addCriterion("pr_fefundType is null");
            return (Criteria) this;
        }

        public Criteria andPrFefundtypeIsNotNull() {
            addCriterion("pr_fefundType is not null");
            return (Criteria) this;
        }

        public Criteria andPrFefundtypeEqualTo(String value) {
            addCriterion("pr_fefundType =", value, "prFefundtype");
            return (Criteria) this;
        }

        public Criteria andPrFefundtypeNotEqualTo(String value) {
            addCriterion("pr_fefundType <>", value, "prFefundtype");
            return (Criteria) this;
        }

        public Criteria andPrFefundtypeGreaterThan(String value) {
            addCriterion("pr_fefundType >", value, "prFefundtype");
            return (Criteria) this;
        }

        public Criteria andPrFefundtypeGreaterThanOrEqualTo(String value) {
            addCriterion("pr_fefundType >=", value, "prFefundtype");
            return (Criteria) this;
        }

        public Criteria andPrFefundtypeLessThan(String value) {
            addCriterion("pr_fefundType <", value, "prFefundtype");
            return (Criteria) this;
        }

        public Criteria andPrFefundtypeLessThanOrEqualTo(String value) {
            addCriterion("pr_fefundType <=", value, "prFefundtype");
            return (Criteria) this;
        }

        public Criteria andPrFefundtypeLike(String value) {
            addCriterion("pr_fefundType like", value, "prFefundtype");
            return (Criteria) this;
        }

        public Criteria andPrFefundtypeNotLike(String value) {
            addCriterion("pr_fefundType not like", value, "prFefundtype");
            return (Criteria) this;
        }

        public Criteria andPrFefundtypeIn(List<String> values) {
            addCriterion("pr_fefundType in", values, "prFefundtype");
            return (Criteria) this;
        }

        public Criteria andPrFefundtypeNotIn(List<String> values) {
            addCriterion("pr_fefundType not in", values, "prFefundtype");
            return (Criteria) this;
        }

        public Criteria andPrFefundtypeBetween(String value1, String value2) {
            addCriterion("pr_fefundType between", value1, value2, "prFefundtype");
            return (Criteria) this;
        }

        public Criteria andPrFefundtypeNotBetween(String value1, String value2) {
            addCriterion("pr_fefundType not between", value1, value2, "prFefundtype");
            return (Criteria) this;
        }

        public Criteria andPrOriginalnoIsNull() {
            addCriterion("pr_originalNo is null");
            return (Criteria) this;
        }

        public Criteria andPrOriginalnoIsNotNull() {
            addCriterion("pr_originalNo is not null");
            return (Criteria) this;
        }

        public Criteria andPrOriginalnoEqualTo(String value) {
            addCriterion("pr_originalNo =", value, "prOriginalno");
            return (Criteria) this;
        }

        public Criteria andPrOriginalnoNotEqualTo(String value) {
            addCriterion("pr_originalNo <>", value, "prOriginalno");
            return (Criteria) this;
        }

        public Criteria andPrOriginalnoGreaterThan(String value) {
            addCriterion("pr_originalNo >", value, "prOriginalno");
            return (Criteria) this;
        }

        public Criteria andPrOriginalnoGreaterThanOrEqualTo(String value) {
            addCriterion("pr_originalNo >=", value, "prOriginalno");
            return (Criteria) this;
        }

        public Criteria andPrOriginalnoLessThan(String value) {
            addCriterion("pr_originalNo <", value, "prOriginalno");
            return (Criteria) this;
        }

        public Criteria andPrOriginalnoLessThanOrEqualTo(String value) {
            addCriterion("pr_originalNo <=", value, "prOriginalno");
            return (Criteria) this;
        }

        public Criteria andPrOriginalnoLike(String value) {
            addCriterion("pr_originalNo like", value, "prOriginalno");
            return (Criteria) this;
        }

        public Criteria andPrOriginalnoNotLike(String value) {
            addCriterion("pr_originalNo not like", value, "prOriginalno");
            return (Criteria) this;
        }

        public Criteria andPrOriginalnoIn(List<String> values) {
            addCriterion("pr_originalNo in", values, "prOriginalno");
            return (Criteria) this;
        }

        public Criteria andPrOriginalnoNotIn(List<String> values) {
            addCriterion("pr_originalNo not in", values, "prOriginalno");
            return (Criteria) this;
        }

        public Criteria andPrOriginalnoBetween(String value1, String value2) {
            addCriterion("pr_originalNo between", value1, value2, "prOriginalno");
            return (Criteria) this;
        }

        public Criteria andPrOriginalnoNotBetween(String value1, String value2) {
            addCriterion("pr_originalNo not between", value1, value2, "prOriginalno");
            return (Criteria) this;
        }

        public Criteria andPrStatusIsNull() {
            addCriterion("pr_status is null");
            return (Criteria) this;
        }

        public Criteria andPrStatusIsNotNull() {
            addCriterion("pr_status is not null");
            return (Criteria) this;
        }

        public Criteria andPrStatusEqualTo(String value) {
            addCriterion("pr_status =", value, "prStatus");
            return (Criteria) this;
        }

        public Criteria andPrStatusNotEqualTo(String value) {
            addCriterion("pr_status <>", value, "prStatus");
            return (Criteria) this;
        }

        public Criteria andPrStatusGreaterThan(String value) {
            addCriterion("pr_status >", value, "prStatus");
            return (Criteria) this;
        }

        public Criteria andPrStatusGreaterThanOrEqualTo(String value) {
            addCriterion("pr_status >=", value, "prStatus");
            return (Criteria) this;
        }

        public Criteria andPrStatusLessThan(String value) {
            addCriterion("pr_status <", value, "prStatus");
            return (Criteria) this;
        }

        public Criteria andPrStatusLessThanOrEqualTo(String value) {
            addCriterion("pr_status <=", value, "prStatus");
            return (Criteria) this;
        }

        public Criteria andPrStatusLike(String value) {
            addCriterion("pr_status like", value, "prStatus");
            return (Criteria) this;
        }

        public Criteria andPrStatusNotLike(String value) {
            addCriterion("pr_status not like", value, "prStatus");
            return (Criteria) this;
        }

        public Criteria andPrStatusIn(List<String> values) {
            addCriterion("pr_status in", values, "prStatus");
            return (Criteria) this;
        }

        public Criteria andPrStatusNotIn(List<String> values) {
            addCriterion("pr_status not in", values, "prStatus");
            return (Criteria) this;
        }

        public Criteria andPrStatusBetween(String value1, String value2) {
            addCriterion("pr_status between", value1, value2, "prStatus");
            return (Criteria) this;
        }

        public Criteria andPrStatusNotBetween(String value1, String value2) {
            addCriterion("pr_status not between", value1, value2, "prStatus");
            return (Criteria) this;
        }

        public Criteria andPrRemarkIsNull() {
            addCriterion("pr_remark is null");
            return (Criteria) this;
        }

        public Criteria andPrRemarkIsNotNull() {
            addCriterion("pr_remark is not null");
            return (Criteria) this;
        }

        public Criteria andPrRemarkEqualTo(String value) {
            addCriterion("pr_remark =", value, "prRemark");
            return (Criteria) this;
        }

        public Criteria andPrRemarkNotEqualTo(String value) {
            addCriterion("pr_remark <>", value, "prRemark");
            return (Criteria) this;
        }

        public Criteria andPrRemarkGreaterThan(String value) {
            addCriterion("pr_remark >", value, "prRemark");
            return (Criteria) this;
        }

        public Criteria andPrRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("pr_remark >=", value, "prRemark");
            return (Criteria) this;
        }

        public Criteria andPrRemarkLessThan(String value) {
            addCriterion("pr_remark <", value, "prRemark");
            return (Criteria) this;
        }

        public Criteria andPrRemarkLessThanOrEqualTo(String value) {
            addCriterion("pr_remark <=", value, "prRemark");
            return (Criteria) this;
        }

        public Criteria andPrRemarkLike(String value) {
            addCriterion("pr_remark like", value, "prRemark");
            return (Criteria) this;
        }

        public Criteria andPrRemarkNotLike(String value) {
            addCriterion("pr_remark not like", value, "prRemark");
            return (Criteria) this;
        }

        public Criteria andPrRemarkIn(List<String> values) {
            addCriterion("pr_remark in", values, "prRemark");
            return (Criteria) this;
        }

        public Criteria andPrRemarkNotIn(List<String> values) {
            addCriterion("pr_remark not in", values, "prRemark");
            return (Criteria) this;
        }

        public Criteria andPrRemarkBetween(String value1, String value2) {
            addCriterion("pr_remark between", value1, value2, "prRemark");
            return (Criteria) this;
        }

        public Criteria andPrRemarkNotBetween(String value1, String value2) {
            addCriterion("pr_remark not between", value1, value2, "prRemark");
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