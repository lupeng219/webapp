package com.baibao.web.p2p.generator.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class P2p_public_orderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public P2p_public_orderExample() {
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

        public Criteria andPpoOrderflownoIsNull() {
            addCriterion("ppo_orderFlowNo is null");
            return (Criteria) this;
        }

        public Criteria andPpoOrderflownoIsNotNull() {
            addCriterion("ppo_orderFlowNo is not null");
            return (Criteria) this;
        }

        public Criteria andPpoOrderflownoEqualTo(String value) {
            addCriterion("ppo_orderFlowNo =", value, "ppoOrderflowno");
            return (Criteria) this;
        }

        public Criteria andPpoOrderflownoNotEqualTo(String value) {
            addCriterion("ppo_orderFlowNo <>", value, "ppoOrderflowno");
            return (Criteria) this;
        }

        public Criteria andPpoOrderflownoGreaterThan(String value) {
            addCriterion("ppo_orderFlowNo >", value, "ppoOrderflowno");
            return (Criteria) this;
        }

        public Criteria andPpoOrderflownoGreaterThanOrEqualTo(String value) {
            addCriterion("ppo_orderFlowNo >=", value, "ppoOrderflowno");
            return (Criteria) this;
        }

        public Criteria andPpoOrderflownoLessThan(String value) {
            addCriterion("ppo_orderFlowNo <", value, "ppoOrderflowno");
            return (Criteria) this;
        }

        public Criteria andPpoOrderflownoLessThanOrEqualTo(String value) {
            addCriterion("ppo_orderFlowNo <=", value, "ppoOrderflowno");
            return (Criteria) this;
        }

        public Criteria andPpoOrderflownoLike(String value) {
            addCriterion("ppo_orderFlowNo like", value, "ppoOrderflowno");
            return (Criteria) this;
        }

        public Criteria andPpoOrderflownoNotLike(String value) {
            addCriterion("ppo_orderFlowNo not like", value, "ppoOrderflowno");
            return (Criteria) this;
        }

        public Criteria andPpoOrderflownoIn(List<String> values) {
            addCriterion("ppo_orderFlowNo in", values, "ppoOrderflowno");
            return (Criteria) this;
        }

        public Criteria andPpoOrderflownoNotIn(List<String> values) {
            addCriterion("ppo_orderFlowNo not in", values, "ppoOrderflowno");
            return (Criteria) this;
        }

        public Criteria andPpoOrderflownoBetween(String value1, String value2) {
            addCriterion("ppo_orderFlowNo between", value1, value2, "ppoOrderflowno");
            return (Criteria) this;
        }

        public Criteria andPpoOrderflownoNotBetween(String value1, String value2) {
            addCriterion("ppo_orderFlowNo not between", value1, value2, "ppoOrderflowno");
            return (Criteria) this;
        }

        public Criteria andPpoCustnoIsNull() {
            addCriterion("ppo_custNo is null");
            return (Criteria) this;
        }

        public Criteria andPpoCustnoIsNotNull() {
            addCriterion("ppo_custNo is not null");
            return (Criteria) this;
        }

        public Criteria andPpoCustnoEqualTo(String value) {
            addCriterion("ppo_custNo =", value, "ppoCustno");
            return (Criteria) this;
        }

        public Criteria andPpoCustnoNotEqualTo(String value) {
            addCriterion("ppo_custNo <>", value, "ppoCustno");
            return (Criteria) this;
        }

        public Criteria andPpoCustnoGreaterThan(String value) {
            addCriterion("ppo_custNo >", value, "ppoCustno");
            return (Criteria) this;
        }

        public Criteria andPpoCustnoGreaterThanOrEqualTo(String value) {
            addCriterion("ppo_custNo >=", value, "ppoCustno");
            return (Criteria) this;
        }

        public Criteria andPpoCustnoLessThan(String value) {
            addCriterion("ppo_custNo <", value, "ppoCustno");
            return (Criteria) this;
        }

        public Criteria andPpoCustnoLessThanOrEqualTo(String value) {
            addCriterion("ppo_custNo <=", value, "ppoCustno");
            return (Criteria) this;
        }

        public Criteria andPpoCustnoLike(String value) {
            addCriterion("ppo_custNo like", value, "ppoCustno");
            return (Criteria) this;
        }

        public Criteria andPpoCustnoNotLike(String value) {
            addCriterion("ppo_custNo not like", value, "ppoCustno");
            return (Criteria) this;
        }

        public Criteria andPpoCustnoIn(List<String> values) {
            addCriterion("ppo_custNo in", values, "ppoCustno");
            return (Criteria) this;
        }

        public Criteria andPpoCustnoNotIn(List<String> values) {
            addCriterion("ppo_custNo not in", values, "ppoCustno");
            return (Criteria) this;
        }

        public Criteria andPpoCustnoBetween(String value1, String value2) {
            addCriterion("ppo_custNo between", value1, value2, "ppoCustno");
            return (Criteria) this;
        }

        public Criteria andPpoCustnoNotBetween(String value1, String value2) {
            addCriterion("ppo_custNo not between", value1, value2, "ppoCustno");
            return (Criteria) this;
        }

        public Criteria andPpoBussTypeIsNull() {
            addCriterion("ppo_buss_type is null");
            return (Criteria) this;
        }

        public Criteria andPpoBussTypeIsNotNull() {
            addCriterion("ppo_buss_type is not null");
            return (Criteria) this;
        }

        public Criteria andPpoBussTypeEqualTo(Integer value) {
            addCriterion("ppo_buss_type =", value, "ppoBussType");
            return (Criteria) this;
        }

        public Criteria andPpoBussTypeNotEqualTo(Integer value) {
            addCriterion("ppo_buss_type <>", value, "ppoBussType");
            return (Criteria) this;
        }

        public Criteria andPpoBussTypeGreaterThan(Integer value) {
            addCriterion("ppo_buss_type >", value, "ppoBussType");
            return (Criteria) this;
        }

        public Criteria andPpoBussTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ppo_buss_type >=", value, "ppoBussType");
            return (Criteria) this;
        }

        public Criteria andPpoBussTypeLessThan(Integer value) {
            addCriterion("ppo_buss_type <", value, "ppoBussType");
            return (Criteria) this;
        }

        public Criteria andPpoBussTypeLessThanOrEqualTo(Integer value) {
            addCriterion("ppo_buss_type <=", value, "ppoBussType");
            return (Criteria) this;
        }

        public Criteria andPpoBussTypeIn(List<Integer> values) {
            addCriterion("ppo_buss_type in", values, "ppoBussType");
            return (Criteria) this;
        }

        public Criteria andPpoBussTypeNotIn(List<Integer> values) {
            addCriterion("ppo_buss_type not in", values, "ppoBussType");
            return (Criteria) this;
        }

        public Criteria andPpoBussTypeBetween(Integer value1, Integer value2) {
            addCriterion("ppo_buss_type between", value1, value2, "ppoBussType");
            return (Criteria) this;
        }

        public Criteria andPpoBussTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("ppo_buss_type not between", value1, value2, "ppoBussType");
            return (Criteria) this;
        }

        public Criteria andPpoOrderTimeIsNull() {
            addCriterion("ppo_order_time is null");
            return (Criteria) this;
        }

        public Criteria andPpoOrderTimeIsNotNull() {
            addCriterion("ppo_order_time is not null");
            return (Criteria) this;
        }

        public Criteria andPpoOrderTimeEqualTo(Date value) {
            addCriterion("ppo_order_time =", value, "ppoOrderTime");
            return (Criteria) this;
        }

        public Criteria andPpoOrderTimeNotEqualTo(Date value) {
            addCriterion("ppo_order_time <>", value, "ppoOrderTime");
            return (Criteria) this;
        }

        public Criteria andPpoOrderTimeGreaterThan(Date value) {
            addCriterion("ppo_order_time >", value, "ppoOrderTime");
            return (Criteria) this;
        }

        public Criteria andPpoOrderTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ppo_order_time >=", value, "ppoOrderTime");
            return (Criteria) this;
        }

        public Criteria andPpoOrderTimeLessThan(Date value) {
            addCriterion("ppo_order_time <", value, "ppoOrderTime");
            return (Criteria) this;
        }

        public Criteria andPpoOrderTimeLessThanOrEqualTo(Date value) {
            addCriterion("ppo_order_time <=", value, "ppoOrderTime");
            return (Criteria) this;
        }

        public Criteria andPpoOrderTimeIn(List<Date> values) {
            addCriterion("ppo_order_time in", values, "ppoOrderTime");
            return (Criteria) this;
        }

        public Criteria andPpoOrderTimeNotIn(List<Date> values) {
            addCriterion("ppo_order_time not in", values, "ppoOrderTime");
            return (Criteria) this;
        }

        public Criteria andPpoOrderTimeBetween(Date value1, Date value2) {
            addCriterion("ppo_order_time between", value1, value2, "ppoOrderTime");
            return (Criteria) this;
        }

        public Criteria andPpoOrderTimeNotBetween(Date value1, Date value2) {
            addCriterion("ppo_order_time not between", value1, value2, "ppoOrderTime");
            return (Criteria) this;
        }

        public Criteria andPpoAccountchannelIsNull() {
            addCriterion("ppo_accountChannel is null");
            return (Criteria) this;
        }

        public Criteria andPpoAccountchannelIsNotNull() {
            addCriterion("ppo_accountChannel is not null");
            return (Criteria) this;
        }

        public Criteria andPpoAccountchannelEqualTo(String value) {
            addCriterion("ppo_accountChannel =", value, "ppoAccountchannel");
            return (Criteria) this;
        }

        public Criteria andPpoAccountchannelNotEqualTo(String value) {
            addCriterion("ppo_accountChannel <>", value, "ppoAccountchannel");
            return (Criteria) this;
        }

        public Criteria andPpoAccountchannelGreaterThan(String value) {
            addCriterion("ppo_accountChannel >", value, "ppoAccountchannel");
            return (Criteria) this;
        }

        public Criteria andPpoAccountchannelGreaterThanOrEqualTo(String value) {
            addCriterion("ppo_accountChannel >=", value, "ppoAccountchannel");
            return (Criteria) this;
        }

        public Criteria andPpoAccountchannelLessThan(String value) {
            addCriterion("ppo_accountChannel <", value, "ppoAccountchannel");
            return (Criteria) this;
        }

        public Criteria andPpoAccountchannelLessThanOrEqualTo(String value) {
            addCriterion("ppo_accountChannel <=", value, "ppoAccountchannel");
            return (Criteria) this;
        }

        public Criteria andPpoAccountchannelLike(String value) {
            addCriterion("ppo_accountChannel like", value, "ppoAccountchannel");
            return (Criteria) this;
        }

        public Criteria andPpoAccountchannelNotLike(String value) {
            addCriterion("ppo_accountChannel not like", value, "ppoAccountchannel");
            return (Criteria) this;
        }

        public Criteria andPpoAccountchannelIn(List<String> values) {
            addCriterion("ppo_accountChannel in", values, "ppoAccountchannel");
            return (Criteria) this;
        }

        public Criteria andPpoAccountchannelNotIn(List<String> values) {
            addCriterion("ppo_accountChannel not in", values, "ppoAccountchannel");
            return (Criteria) this;
        }

        public Criteria andPpoAccountchannelBetween(String value1, String value2) {
            addCriterion("ppo_accountChannel between", value1, value2, "ppoAccountchannel");
            return (Criteria) this;
        }

        public Criteria andPpoAccountchannelNotBetween(String value1, String value2) {
            addCriterion("ppo_accountChannel not between", value1, value2, "ppoAccountchannel");
            return (Criteria) this;
        }

        public Criteria andPpoStatusIsNull() {
            addCriterion("ppo_status is null");
            return (Criteria) this;
        }

        public Criteria andPpoStatusIsNotNull() {
            addCriterion("ppo_status is not null");
            return (Criteria) this;
        }

        public Criteria andPpoStatusEqualTo(String value) {
            addCriterion("ppo_status =", value, "ppoStatus");
            return (Criteria) this;
        }

        public Criteria andPpoStatusNotEqualTo(String value) {
            addCriterion("ppo_status <>", value, "ppoStatus");
            return (Criteria) this;
        }

        public Criteria andPpoStatusGreaterThan(String value) {
            addCriterion("ppo_status >", value, "ppoStatus");
            return (Criteria) this;
        }

        public Criteria andPpoStatusGreaterThanOrEqualTo(String value) {
            addCriterion("ppo_status >=", value, "ppoStatus");
            return (Criteria) this;
        }

        public Criteria andPpoStatusLessThan(String value) {
            addCriterion("ppo_status <", value, "ppoStatus");
            return (Criteria) this;
        }

        public Criteria andPpoStatusLessThanOrEqualTo(String value) {
            addCriterion("ppo_status <=", value, "ppoStatus");
            return (Criteria) this;
        }

        public Criteria andPpoStatusLike(String value) {
            addCriterion("ppo_status like", value, "ppoStatus");
            return (Criteria) this;
        }

        public Criteria andPpoStatusNotLike(String value) {
            addCriterion("ppo_status not like", value, "ppoStatus");
            return (Criteria) this;
        }

        public Criteria andPpoStatusIn(List<String> values) {
            addCriterion("ppo_status in", values, "ppoStatus");
            return (Criteria) this;
        }

        public Criteria andPpoStatusNotIn(List<String> values) {
            addCriterion("ppo_status not in", values, "ppoStatus");
            return (Criteria) this;
        }

        public Criteria andPpoStatusBetween(String value1, String value2) {
            addCriterion("ppo_status between", value1, value2, "ppoStatus");
            return (Criteria) this;
        }

        public Criteria andPpoStatusNotBetween(String value1, String value2) {
            addCriterion("ppo_status not between", value1, value2, "ppoStatus");
            return (Criteria) this;
        }

        public Criteria andPpoParamsIsNull() {
            addCriterion("ppo_params is null");
            return (Criteria) this;
        }

        public Criteria andPpoParamsIsNotNull() {
            addCriterion("ppo_params is not null");
            return (Criteria) this;
        }

        public Criteria andPpoParamsEqualTo(String value) {
            addCriterion("ppo_params =", value, "ppoParams");
            return (Criteria) this;
        }

        public Criteria andPpoParamsNotEqualTo(String value) {
            addCriterion("ppo_params <>", value, "ppoParams");
            return (Criteria) this;
        }

        public Criteria andPpoParamsGreaterThan(String value) {
            addCriterion("ppo_params >", value, "ppoParams");
            return (Criteria) this;
        }

        public Criteria andPpoParamsGreaterThanOrEqualTo(String value) {
            addCriterion("ppo_params >=", value, "ppoParams");
            return (Criteria) this;
        }

        public Criteria andPpoParamsLessThan(String value) {
            addCriterion("ppo_params <", value, "ppoParams");
            return (Criteria) this;
        }

        public Criteria andPpoParamsLessThanOrEqualTo(String value) {
            addCriterion("ppo_params <=", value, "ppoParams");
            return (Criteria) this;
        }

        public Criteria andPpoParamsLike(String value) {
            addCriterion("ppo_params like", value, "ppoParams");
            return (Criteria) this;
        }

        public Criteria andPpoParamsNotLike(String value) {
            addCriterion("ppo_params not like", value, "ppoParams");
            return (Criteria) this;
        }

        public Criteria andPpoParamsIn(List<String> values) {
            addCriterion("ppo_params in", values, "ppoParams");
            return (Criteria) this;
        }

        public Criteria andPpoParamsNotIn(List<String> values) {
            addCriterion("ppo_params not in", values, "ppoParams");
            return (Criteria) this;
        }

        public Criteria andPpoParamsBetween(String value1, String value2) {
            addCriterion("ppo_params between", value1, value2, "ppoParams");
            return (Criteria) this;
        }

        public Criteria andPpoParamsNotBetween(String value1, String value2) {
            addCriterion("ppo_params not between", value1, value2, "ppoParams");
            return (Criteria) this;
        }

        public Criteria andPpoParentflownoIsNull() {
            addCriterion("ppo_parentFlowNo is null");
            return (Criteria) this;
        }

        public Criteria andPpoParentflownoIsNotNull() {
            addCriterion("ppo_parentFlowNo is not null");
            return (Criteria) this;
        }

        public Criteria andPpoParentflownoEqualTo(String value) {
            addCriterion("ppo_parentFlowNo =", value, "ppoParentflowno");
            return (Criteria) this;
        }

        public Criteria andPpoParentflownoNotEqualTo(String value) {
            addCriterion("ppo_parentFlowNo <>", value, "ppoParentflowno");
            return (Criteria) this;
        }

        public Criteria andPpoParentflownoGreaterThan(String value) {
            addCriterion("ppo_parentFlowNo >", value, "ppoParentflowno");
            return (Criteria) this;
        }

        public Criteria andPpoParentflownoGreaterThanOrEqualTo(String value) {
            addCriterion("ppo_parentFlowNo >=", value, "ppoParentflowno");
            return (Criteria) this;
        }

        public Criteria andPpoParentflownoLessThan(String value) {
            addCriterion("ppo_parentFlowNo <", value, "ppoParentflowno");
            return (Criteria) this;
        }

        public Criteria andPpoParentflownoLessThanOrEqualTo(String value) {
            addCriterion("ppo_parentFlowNo <=", value, "ppoParentflowno");
            return (Criteria) this;
        }

        public Criteria andPpoParentflownoLike(String value) {
            addCriterion("ppo_parentFlowNo like", value, "ppoParentflowno");
            return (Criteria) this;
        }

        public Criteria andPpoParentflownoNotLike(String value) {
            addCriterion("ppo_parentFlowNo not like", value, "ppoParentflowno");
            return (Criteria) this;
        }

        public Criteria andPpoParentflownoIn(List<String> values) {
            addCriterion("ppo_parentFlowNo in", values, "ppoParentflowno");
            return (Criteria) this;
        }

        public Criteria andPpoParentflownoNotIn(List<String> values) {
            addCriterion("ppo_parentFlowNo not in", values, "ppoParentflowno");
            return (Criteria) this;
        }

        public Criteria andPpoParentflownoBetween(String value1, String value2) {
            addCriterion("ppo_parentFlowNo between", value1, value2, "ppoParentflowno");
            return (Criteria) this;
        }

        public Criteria andPpoParentflownoNotBetween(String value1, String value2) {
            addCriterion("ppo_parentFlowNo not between", value1, value2, "ppoParentflowno");
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