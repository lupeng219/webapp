package com.baibao.web.p2p.generator.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class P2p_user_roleExample implements Serializable{
    
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public P2p_user_roleExample() {
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

        public Criteria andPurIdIsNull() {
            addCriterion("pur_id is null");
            return (Criteria) this;
        }

        public Criteria andPurIdIsNotNull() {
            addCriterion("pur_id is not null");
            return (Criteria) this;
        }

        public Criteria andPurIdEqualTo(Long value) {
            addCriterion("pur_id =", value, "purId");
            return (Criteria) this;
        }

        public Criteria andPurIdNotEqualTo(Long value) {
            addCriterion("pur_id <>", value, "purId");
            return (Criteria) this;
        }

        public Criteria andPurIdGreaterThan(Long value) {
            addCriterion("pur_id >", value, "purId");
            return (Criteria) this;
        }

        public Criteria andPurIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pur_id >=", value, "purId");
            return (Criteria) this;
        }

        public Criteria andPurIdLessThan(Long value) {
            addCriterion("pur_id <", value, "purId");
            return (Criteria) this;
        }

        public Criteria andPurIdLessThanOrEqualTo(Long value) {
            addCriterion("pur_id <=", value, "purId");
            return (Criteria) this;
        }

        public Criteria andPurIdIn(List<Long> values) {
            addCriterion("pur_id in", values, "purId");
            return (Criteria) this;
        }

        public Criteria andPurIdNotIn(List<Long> values) {
            addCriterion("pur_id not in", values, "purId");
            return (Criteria) this;
        }

        public Criteria andPurIdBetween(Long value1, Long value2) {
            addCriterion("pur_id between", value1, value2, "purId");
            return (Criteria) this;
        }

        public Criteria andPurIdNotBetween(Long value1, Long value2) {
            addCriterion("pur_id not between", value1, value2, "purId");
            return (Criteria) this;
        }

        public Criteria andPurRolecodeIsNull() {
            addCriterion("pur_roleCode is null");
            return (Criteria) this;
        }

        public Criteria andPurRolecodeIsNotNull() {
            addCriterion("pur_roleCode is not null");
            return (Criteria) this;
        }

        public Criteria andPurRolecodeEqualTo(String value) {
            addCriterion("pur_roleCode =", value, "purRolecode");
            return (Criteria) this;
        }

        public Criteria andPurRolecodeNotEqualTo(String value) {
            addCriterion("pur_roleCode <>", value, "purRolecode");
            return (Criteria) this;
        }

        public Criteria andPurRolecodeGreaterThan(String value) {
            addCriterion("pur_roleCode >", value, "purRolecode");
            return (Criteria) this;
        }

        public Criteria andPurRolecodeGreaterThanOrEqualTo(String value) {
            addCriterion("pur_roleCode >=", value, "purRolecode");
            return (Criteria) this;
        }

        public Criteria andPurRolecodeLessThan(String value) {
            addCriterion("pur_roleCode <", value, "purRolecode");
            return (Criteria) this;
        }

        public Criteria andPurRolecodeLessThanOrEqualTo(String value) {
            addCriterion("pur_roleCode <=", value, "purRolecode");
            return (Criteria) this;
        }

        public Criteria andPurRolecodeLike(String value) {
            addCriterion("pur_roleCode like", value, "purRolecode");
            return (Criteria) this;
        }

        public Criteria andPurRolecodeNotLike(String value) {
            addCriterion("pur_roleCode not like", value, "purRolecode");
            return (Criteria) this;
        }

        public Criteria andPurRolecodeIn(List<String> values) {
            addCriterion("pur_roleCode in", values, "purRolecode");
            return (Criteria) this;
        }

        public Criteria andPurRolecodeNotIn(List<String> values) {
            addCriterion("pur_roleCode not in", values, "purRolecode");
            return (Criteria) this;
        }

        public Criteria andPurRolecodeBetween(String value1, String value2) {
            addCriterion("pur_roleCode between", value1, value2, "purRolecode");
            return (Criteria) this;
        }

        public Criteria andPurRolecodeNotBetween(String value1, String value2) {
            addCriterion("pur_roleCode not between", value1, value2, "purRolecode");
            return (Criteria) this;
        }

        public Criteria andPurCustnoIsNull() {
            addCriterion("pur_custNo is null");
            return (Criteria) this;
        }

        public Criteria andPurCustnoIsNotNull() {
            addCriterion("pur_custNo is not null");
            return (Criteria) this;
        }

        public Criteria andPurCustnoEqualTo(String value) {
            addCriterion("pur_custNo =", value, "purCustno");
            return (Criteria) this;
        }

        public Criteria andPurCustnoNotEqualTo(String value) {
            addCriterion("pur_custNo <>", value, "purCustno");
            return (Criteria) this;
        }

        public Criteria andPurCustnoGreaterThan(String value) {
            addCriterion("pur_custNo >", value, "purCustno");
            return (Criteria) this;
        }

        public Criteria andPurCustnoGreaterThanOrEqualTo(String value) {
            addCriterion("pur_custNo >=", value, "purCustno");
            return (Criteria) this;
        }

        public Criteria andPurCustnoLessThan(String value) {
            addCriterion("pur_custNo <", value, "purCustno");
            return (Criteria) this;
        }

        public Criteria andPurCustnoLessThanOrEqualTo(String value) {
            addCriterion("pur_custNo <=", value, "purCustno");
            return (Criteria) this;
        }

        public Criteria andPurCustnoLike(String value) {
            addCriterion("pur_custNo like", value, "purCustno");
            return (Criteria) this;
        }

        public Criteria andPurCustnoNotLike(String value) {
            addCriterion("pur_custNo not like", value, "purCustno");
            return (Criteria) this;
        }

        public Criteria andPurCustnoIn(List<String> values) {
            addCriterion("pur_custNo in", values, "purCustno");
            return (Criteria) this;
        }

        public Criteria andPurCustnoNotIn(List<String> values) {
            addCriterion("pur_custNo not in", values, "purCustno");
            return (Criteria) this;
        }

        public Criteria andPurCustnoBetween(String value1, String value2) {
            addCriterion("pur_custNo between", value1, value2, "purCustno");
            return (Criteria) this;
        }

        public Criteria andPurCustnoNotBetween(String value1, String value2) {
            addCriterion("pur_custNo not between", value1, value2, "purCustno");
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