package com.baibao.web.p2p.generator.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class P2p_loan_product_pictureExample implements Serializable{
   
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public P2p_loan_product_pictureExample() {
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

        public Criteria andPlpPictureidIsNull() {
            addCriterion("plp_pictureId is null");
            return (Criteria) this;
        }

        public Criteria andPlpPictureidIsNotNull() {
            addCriterion("plp_pictureId is not null");
            return (Criteria) this;
        }

        public Criteria andPlpPictureidEqualTo(Long value) {
            addCriterion("plp_pictureId =", value, "plpPictureid");
            return (Criteria) this;
        }

        public Criteria andPlpPictureidNotEqualTo(Long value) {
            addCriterion("plp_pictureId <>", value, "plpPictureid");
            return (Criteria) this;
        }

        public Criteria andPlpPictureidGreaterThan(Long value) {
            addCriterion("plp_pictureId >", value, "plpPictureid");
            return (Criteria) this;
        }

        public Criteria andPlpPictureidGreaterThanOrEqualTo(Long value) {
            addCriterion("plp_pictureId >=", value, "plpPictureid");
            return (Criteria) this;
        }

        public Criteria andPlpPictureidLessThan(Long value) {
            addCriterion("plp_pictureId <", value, "plpPictureid");
            return (Criteria) this;
        }

        public Criteria andPlpPictureidLessThanOrEqualTo(Long value) {
            addCriterion("plp_pictureId <=", value, "plpPictureid");
            return (Criteria) this;
        }

        public Criteria andPlpPictureidIn(List<Long> values) {
            addCriterion("plp_pictureId in", values, "plpPictureid");
            return (Criteria) this;
        }

        public Criteria andPlpPictureidNotIn(List<Long> values) {
            addCriterion("plp_pictureId not in", values, "plpPictureid");
            return (Criteria) this;
        }

        public Criteria andPlpPictureidBetween(Long value1, Long value2) {
            addCriterion("plp_pictureId between", value1, value2, "plpPictureid");
            return (Criteria) this;
        }

        public Criteria andPlpPictureidNotBetween(Long value1, Long value2) {
            addCriterion("plp_pictureId not between", value1, value2, "plpPictureid");
            return (Criteria) this;
        }

        public Criteria andPlpProductnoIsNull() {
            addCriterion("plp_productNo is null");
            return (Criteria) this;
        }

        public Criteria andPlpProductnoIsNotNull() {
            addCriterion("plp_productNo is not null");
            return (Criteria) this;
        }

        public Criteria andPlpProductnoEqualTo(String value) {
            addCriterion("plp_productNo =", value, "plpProductno");
            return (Criteria) this;
        }

        public Criteria andPlpProductnoNotEqualTo(String value) {
            addCriterion("plp_productNo <>", value, "plpProductno");
            return (Criteria) this;
        }

        public Criteria andPlpProductnoGreaterThan(String value) {
            addCriterion("plp_productNo >", value, "plpProductno");
            return (Criteria) this;
        }

        public Criteria andPlpProductnoGreaterThanOrEqualTo(String value) {
            addCriterion("plp_productNo >=", value, "plpProductno");
            return (Criteria) this;
        }

        public Criteria andPlpProductnoLessThan(String value) {
            addCriterion("plp_productNo <", value, "plpProductno");
            return (Criteria) this;
        }

        public Criteria andPlpProductnoLessThanOrEqualTo(String value) {
            addCriterion("plp_productNo <=", value, "plpProductno");
            return (Criteria) this;
        }

        public Criteria andPlpProductnoLike(String value) {
            addCriterion("plp_productNo like", value, "plpProductno");
            return (Criteria) this;
        }

        public Criteria andPlpProductnoNotLike(String value) {
            addCriterion("plp_productNo not like", value, "plpProductno");
            return (Criteria) this;
        }

        public Criteria andPlpProductnoIn(List<String> values) {
            addCriterion("plp_productNo in", values, "plpProductno");
            return (Criteria) this;
        }

        public Criteria andPlpProductnoNotIn(List<String> values) {
            addCriterion("plp_productNo not in", values, "plpProductno");
            return (Criteria) this;
        }

        public Criteria andPlpProductnoBetween(String value1, String value2) {
            addCriterion("plp_productNo between", value1, value2, "plpProductno");
            return (Criteria) this;
        }

        public Criteria andPlpProductnoNotBetween(String value1, String value2) {
            addCriterion("plp_productNo not between", value1, value2, "plpProductno");
            return (Criteria) this;
        }

        public Criteria andPlpAddressIsNull() {
            addCriterion("plp_Address is null");
            return (Criteria) this;
        }

        public Criteria andPlpAddressIsNotNull() {
            addCriterion("plp_Address is not null");
            return (Criteria) this;
        }

        public Criteria andPlpAddressEqualTo(String value) {
            addCriterion("plp_Address =", value, "plpAddress");
            return (Criteria) this;
        }

        public Criteria andPlpAddressNotEqualTo(String value) {
            addCriterion("plp_Address <>", value, "plpAddress");
            return (Criteria) this;
        }

        public Criteria andPlpAddressGreaterThan(String value) {
            addCriterion("plp_Address >", value, "plpAddress");
            return (Criteria) this;
        }

        public Criteria andPlpAddressGreaterThanOrEqualTo(String value) {
            addCriterion("plp_Address >=", value, "plpAddress");
            return (Criteria) this;
        }

        public Criteria andPlpAddressLessThan(String value) {
            addCriterion("plp_Address <", value, "plpAddress");
            return (Criteria) this;
        }

        public Criteria andPlpAddressLessThanOrEqualTo(String value) {
            addCriterion("plp_Address <=", value, "plpAddress");
            return (Criteria) this;
        }

        public Criteria andPlpAddressLike(String value) {
            addCriterion("plp_Address like", value, "plpAddress");
            return (Criteria) this;
        }

        public Criteria andPlpAddressNotLike(String value) {
            addCriterion("plp_Address not like", value, "plpAddress");
            return (Criteria) this;
        }

        public Criteria andPlpAddressIn(List<String> values) {
            addCriterion("plp_Address in", values, "plpAddress");
            return (Criteria) this;
        }

        public Criteria andPlpAddressNotIn(List<String> values) {
            addCriterion("plp_Address not in", values, "plpAddress");
            return (Criteria) this;
        }

        public Criteria andPlpAddressBetween(String value1, String value2) {
            addCriterion("plp_Address between", value1, value2, "plpAddress");
            return (Criteria) this;
        }

        public Criteria andPlpAddressNotBetween(String value1, String value2) {
            addCriterion("plp_Address not between", value1, value2, "plpAddress");
            return (Criteria) this;
        }

        public Criteria andPlpDescriptionIsNull() {
            addCriterion("plp_Description is null");
            return (Criteria) this;
        }

        public Criteria andPlpDescriptionIsNotNull() {
            addCriterion("plp_Description is not null");
            return (Criteria) this;
        }

        public Criteria andPlpDescriptionEqualTo(String value) {
            addCriterion("plp_Description =", value, "plpDescription");
            return (Criteria) this;
        }

        public Criteria andPlpDescriptionNotEqualTo(String value) {
            addCriterion("plp_Description <>", value, "plpDescription");
            return (Criteria) this;
        }

        public Criteria andPlpDescriptionGreaterThan(String value) {
            addCriterion("plp_Description >", value, "plpDescription");
            return (Criteria) this;
        }

        public Criteria andPlpDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("plp_Description >=", value, "plpDescription");
            return (Criteria) this;
        }

        public Criteria andPlpDescriptionLessThan(String value) {
            addCriterion("plp_Description <", value, "plpDescription");
            return (Criteria) this;
        }

        public Criteria andPlpDescriptionLessThanOrEqualTo(String value) {
            addCriterion("plp_Description <=", value, "plpDescription");
            return (Criteria) this;
        }

        public Criteria andPlpDescriptionLike(String value) {
            addCriterion("plp_Description like", value, "plpDescription");
            return (Criteria) this;
        }

        public Criteria andPlpDescriptionNotLike(String value) {
            addCriterion("plp_Description not like", value, "plpDescription");
            return (Criteria) this;
        }

        public Criteria andPlpDescriptionIn(List<String> values) {
            addCriterion("plp_Description in", values, "plpDescription");
            return (Criteria) this;
        }

        public Criteria andPlpDescriptionNotIn(List<String> values) {
            addCriterion("plp_Description not in", values, "plpDescription");
            return (Criteria) this;
        }

        public Criteria andPlpDescriptionBetween(String value1, String value2) {
            addCriterion("plp_Description between", value1, value2, "plpDescription");
            return (Criteria) this;
        }

        public Criteria andPlpDescriptionNotBetween(String value1, String value2) {
            addCriterion("plp_Description not between", value1, value2, "plpDescription");
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