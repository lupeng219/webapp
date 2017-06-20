package com.baibao.web.p2p.generator.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class P2p_rolesExample implements Serializable{
    
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public P2p_rolesExample() {
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

        public Criteria andPrRolecodeIsNull() {
            addCriterion("pr_roleCode is null");
            return (Criteria) this;
        }

        public Criteria andPrRolecodeIsNotNull() {
            addCriterion("pr_roleCode is not null");
            return (Criteria) this;
        }

        public Criteria andPrRolecodeEqualTo(String value) {
            addCriterion("pr_roleCode =", value, "prRolecode");
            return (Criteria) this;
        }

        public Criteria andPrRolecodeNotEqualTo(String value) {
            addCriterion("pr_roleCode <>", value, "prRolecode");
            return (Criteria) this;
        }

        public Criteria andPrRolecodeGreaterThan(String value) {
            addCriterion("pr_roleCode >", value, "prRolecode");
            return (Criteria) this;
        }

        public Criteria andPrRolecodeGreaterThanOrEqualTo(String value) {
            addCriterion("pr_roleCode >=", value, "prRolecode");
            return (Criteria) this;
        }

        public Criteria andPrRolecodeLessThan(String value) {
            addCriterion("pr_roleCode <", value, "prRolecode");
            return (Criteria) this;
        }

        public Criteria andPrRolecodeLessThanOrEqualTo(String value) {
            addCriterion("pr_roleCode <=", value, "prRolecode");
            return (Criteria) this;
        }

        public Criteria andPrRolecodeLike(String value) {
            addCriterion("pr_roleCode like", value, "prRolecode");
            return (Criteria) this;
        }

        public Criteria andPrRolecodeNotLike(String value) {
            addCriterion("pr_roleCode not like", value, "prRolecode");
            return (Criteria) this;
        }

        public Criteria andPrRolecodeIn(List<String> values) {
            addCriterion("pr_roleCode in", values, "prRolecode");
            return (Criteria) this;
        }

        public Criteria andPrRolecodeNotIn(List<String> values) {
            addCriterion("pr_roleCode not in", values, "prRolecode");
            return (Criteria) this;
        }

        public Criteria andPrRolecodeBetween(String value1, String value2) {
            addCriterion("pr_roleCode between", value1, value2, "prRolecode");
            return (Criteria) this;
        }

        public Criteria andPrRolecodeNotBetween(String value1, String value2) {
            addCriterion("pr_roleCode not between", value1, value2, "prRolecode");
            return (Criteria) this;
        }

        public Criteria andPrRolenameIsNull() {
            addCriterion("pr_roleName is null");
            return (Criteria) this;
        }

        public Criteria andPrRolenameIsNotNull() {
            addCriterion("pr_roleName is not null");
            return (Criteria) this;
        }

        public Criteria andPrRolenameEqualTo(String value) {
            addCriterion("pr_roleName =", value, "prRolename");
            return (Criteria) this;
        }

        public Criteria andPrRolenameNotEqualTo(String value) {
            addCriterion("pr_roleName <>", value, "prRolename");
            return (Criteria) this;
        }

        public Criteria andPrRolenameGreaterThan(String value) {
            addCriterion("pr_roleName >", value, "prRolename");
            return (Criteria) this;
        }

        public Criteria andPrRolenameGreaterThanOrEqualTo(String value) {
            addCriterion("pr_roleName >=", value, "prRolename");
            return (Criteria) this;
        }

        public Criteria andPrRolenameLessThan(String value) {
            addCriterion("pr_roleName <", value, "prRolename");
            return (Criteria) this;
        }

        public Criteria andPrRolenameLessThanOrEqualTo(String value) {
            addCriterion("pr_roleName <=", value, "prRolename");
            return (Criteria) this;
        }

        public Criteria andPrRolenameLike(String value) {
            addCriterion("pr_roleName like", value, "prRolename");
            return (Criteria) this;
        }

        public Criteria andPrRolenameNotLike(String value) {
            addCriterion("pr_roleName not like", value, "prRolename");
            return (Criteria) this;
        }

        public Criteria andPrRolenameIn(List<String> values) {
            addCriterion("pr_roleName in", values, "prRolename");
            return (Criteria) this;
        }

        public Criteria andPrRolenameNotIn(List<String> values) {
            addCriterion("pr_roleName not in", values, "prRolename");
            return (Criteria) this;
        }

        public Criteria andPrRolenameBetween(String value1, String value2) {
            addCriterion("pr_roleName between", value1, value2, "prRolename");
            return (Criteria) this;
        }

        public Criteria andPrRolenameNotBetween(String value1, String value2) {
            addCriterion("pr_roleName not between", value1, value2, "prRolename");
            return (Criteria) this;
        }

        public Criteria andPrRoledescIsNull() {
            addCriterion("pr_roleDesc is null");
            return (Criteria) this;
        }

        public Criteria andPrRoledescIsNotNull() {
            addCriterion("pr_roleDesc is not null");
            return (Criteria) this;
        }

        public Criteria andPrRoledescEqualTo(String value) {
            addCriterion("pr_roleDesc =", value, "prRoledesc");
            return (Criteria) this;
        }

        public Criteria andPrRoledescNotEqualTo(String value) {
            addCriterion("pr_roleDesc <>", value, "prRoledesc");
            return (Criteria) this;
        }

        public Criteria andPrRoledescGreaterThan(String value) {
            addCriterion("pr_roleDesc >", value, "prRoledesc");
            return (Criteria) this;
        }

        public Criteria andPrRoledescGreaterThanOrEqualTo(String value) {
            addCriterion("pr_roleDesc >=", value, "prRoledesc");
            return (Criteria) this;
        }

        public Criteria andPrRoledescLessThan(String value) {
            addCriterion("pr_roleDesc <", value, "prRoledesc");
            return (Criteria) this;
        }

        public Criteria andPrRoledescLessThanOrEqualTo(String value) {
            addCriterion("pr_roleDesc <=", value, "prRoledesc");
            return (Criteria) this;
        }

        public Criteria andPrRoledescLike(String value) {
            addCriterion("pr_roleDesc like", value, "prRoledesc");
            return (Criteria) this;
        }

        public Criteria andPrRoledescNotLike(String value) {
            addCriterion("pr_roleDesc not like", value, "prRoledesc");
            return (Criteria) this;
        }

        public Criteria andPrRoledescIn(List<String> values) {
            addCriterion("pr_roleDesc in", values, "prRoledesc");
            return (Criteria) this;
        }

        public Criteria andPrRoledescNotIn(List<String> values) {
            addCriterion("pr_roleDesc not in", values, "prRoledesc");
            return (Criteria) this;
        }

        public Criteria andPrRoledescBetween(String value1, String value2) {
            addCriterion("pr_roleDesc between", value1, value2, "prRoledesc");
            return (Criteria) this;
        }

        public Criteria andPrRoledescNotBetween(String value1, String value2) {
            addCriterion("pr_roleDesc not between", value1, value2, "prRoledesc");
            return (Criteria) this;
        }

        public Criteria andREnabledIsNull() {
            addCriterion("R_enabled is null");
            return (Criteria) this;
        }

        public Criteria andREnabledIsNotNull() {
            addCriterion("R_enabled is not null");
            return (Criteria) this;
        }

        public Criteria andREnabledEqualTo(String value) {
            addCriterion("R_enabled =", value, "rEnabled");
            return (Criteria) this;
        }

        public Criteria andREnabledNotEqualTo(String value) {
            addCriterion("R_enabled <>", value, "rEnabled");
            return (Criteria) this;
        }

        public Criteria andREnabledGreaterThan(String value) {
            addCriterion("R_enabled >", value, "rEnabled");
            return (Criteria) this;
        }

        public Criteria andREnabledGreaterThanOrEqualTo(String value) {
            addCriterion("R_enabled >=", value, "rEnabled");
            return (Criteria) this;
        }

        public Criteria andREnabledLessThan(String value) {
            addCriterion("R_enabled <", value, "rEnabled");
            return (Criteria) this;
        }

        public Criteria andREnabledLessThanOrEqualTo(String value) {
            addCriterion("R_enabled <=", value, "rEnabled");
            return (Criteria) this;
        }

        public Criteria andREnabledLike(String value) {
            addCriterion("R_enabled like", value, "rEnabled");
            return (Criteria) this;
        }

        public Criteria andREnabledNotLike(String value) {
            addCriterion("R_enabled not like", value, "rEnabled");
            return (Criteria) this;
        }

        public Criteria andREnabledIn(List<String> values) {
            addCriterion("R_enabled in", values, "rEnabled");
            return (Criteria) this;
        }

        public Criteria andREnabledNotIn(List<String> values) {
            addCriterion("R_enabled not in", values, "rEnabled");
            return (Criteria) this;
        }

        public Criteria andREnabledBetween(String value1, String value2) {
            addCriterion("R_enabled between", value1, value2, "rEnabled");
            return (Criteria) this;
        }

        public Criteria andREnabledNotBetween(String value1, String value2) {
            addCriterion("R_enabled not between", value1, value2, "rEnabled");
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