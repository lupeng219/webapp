package com.baibao.web.p2p.generator.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class P2p_loan_recordExample implements Serializable{
   
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public P2p_loan_recordExample() {
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

        public Criteria andPtfIdIsNull() {
            addCriterion("ptf_id is null");
            return (Criteria) this;
        }

        public Criteria andPtfIdIsNotNull() {
            addCriterion("ptf_id is not null");
            return (Criteria) this;
        }

        public Criteria andPtfIdEqualTo(Long value) {
            addCriterion("ptf_id =", value, "ptfId");
            return (Criteria) this;
        }

        public Criteria andPtfIdNotEqualTo(Long value) {
            addCriterion("ptf_id <>", value, "ptfId");
            return (Criteria) this;
        }

        public Criteria andPtfIdGreaterThan(Long value) {
            addCriterion("ptf_id >", value, "ptfId");
            return (Criteria) this;
        }

        public Criteria andPtfIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ptf_id >=", value, "ptfId");
            return (Criteria) this;
        }

        public Criteria andPtfIdLessThan(Long value) {
            addCriterion("ptf_id <", value, "ptfId");
            return (Criteria) this;
        }

        public Criteria andPtfIdLessThanOrEqualTo(Long value) {
            addCriterion("ptf_id <=", value, "ptfId");
            return (Criteria) this;
        }

        public Criteria andPtfIdIn(List<Long> values) {
            addCriterion("ptf_id in", values, "ptfId");
            return (Criteria) this;
        }

        public Criteria andPtfIdNotIn(List<Long> values) {
            addCriterion("ptf_id not in", values, "ptfId");
            return (Criteria) this;
        }

        public Criteria andPtfIdBetween(Long value1, Long value2) {
            addCriterion("ptf_id between", value1, value2, "ptfId");
            return (Criteria) this;
        }

        public Criteria andPtfIdNotBetween(Long value1, Long value2) {
            addCriterion("ptf_id not between", value1, value2, "ptfId");
            return (Criteria) this;
        }

        public Criteria andPtfTransflownoIsNull() {
            addCriterion("ptf_transFlowNo is null");
            return (Criteria) this;
        }

        public Criteria andPtfTransflownoIsNotNull() {
            addCriterion("ptf_transFlowNo is not null");
            return (Criteria) this;
        }

        public Criteria andPtfTransflownoEqualTo(String value) {
            addCriterion("ptf_transFlowNo =", value, "ptfTransflowno");
            return (Criteria) this;
        }

        public Criteria andPtfTransflownoNotEqualTo(String value) {
            addCriterion("ptf_transFlowNo <>", value, "ptfTransflowno");
            return (Criteria) this;
        }

        public Criteria andPtfTransflownoGreaterThan(String value) {
            addCriterion("ptf_transFlowNo >", value, "ptfTransflowno");
            return (Criteria) this;
        }

        public Criteria andPtfTransflownoGreaterThanOrEqualTo(String value) {
            addCriterion("ptf_transFlowNo >=", value, "ptfTransflowno");
            return (Criteria) this;
        }

        public Criteria andPtfTransflownoLessThan(String value) {
            addCriterion("ptf_transFlowNo <", value, "ptfTransflowno");
            return (Criteria) this;
        }

        public Criteria andPtfTransflownoLessThanOrEqualTo(String value) {
            addCriterion("ptf_transFlowNo <=", value, "ptfTransflowno");
            return (Criteria) this;
        }

        public Criteria andPtfTransflownoLike(String value) {
            addCriterion("ptf_transFlowNo like", value, "ptfTransflowno");
            return (Criteria) this;
        }

        public Criteria andPtfTransflownoNotLike(String value) {
            addCriterion("ptf_transFlowNo not like", value, "ptfTransflowno");
            return (Criteria) this;
        }

        public Criteria andPtfTransflownoIn(List<String> values) {
            addCriterion("ptf_transFlowNo in", values, "ptfTransflowno");
            return (Criteria) this;
        }

        public Criteria andPtfTransflownoNotIn(List<String> values) {
            addCriterion("ptf_transFlowNo not in", values, "ptfTransflowno");
            return (Criteria) this;
        }

        public Criteria andPtfTransflownoBetween(String value1, String value2) {
            addCriterion("ptf_transFlowNo between", value1, value2, "ptfTransflowno");
            return (Criteria) this;
        }

        public Criteria andPtfTransflownoNotBetween(String value1, String value2) {
            addCriterion("ptf_transFlowNo not between", value1, value2, "ptfTransflowno");
            return (Criteria) this;
        }

        public Criteria andPtfOutcstnoIsNull() {
            addCriterion("ptf_outcstno is null");
            return (Criteria) this;
        }

        public Criteria andPtfOutcstnoIsNotNull() {
            addCriterion("ptf_outcstno is not null");
            return (Criteria) this;
        }

        public Criteria andPtfOutcstnoEqualTo(String value) {
            addCriterion("ptf_outcstno =", value, "ptfOutcstno");
            return (Criteria) this;
        }

        public Criteria andPtfOutcstnoNotEqualTo(String value) {
            addCriterion("ptf_outcstno <>", value, "ptfOutcstno");
            return (Criteria) this;
        }

        public Criteria andPtfOutcstnoGreaterThan(String value) {
            addCriterion("ptf_outcstno >", value, "ptfOutcstno");
            return (Criteria) this;
        }

        public Criteria andPtfOutcstnoGreaterThanOrEqualTo(String value) {
            addCriterion("ptf_outcstno >=", value, "ptfOutcstno");
            return (Criteria) this;
        }

        public Criteria andPtfOutcstnoLessThan(String value) {
            addCriterion("ptf_outcstno <", value, "ptfOutcstno");
            return (Criteria) this;
        }

        public Criteria andPtfOutcstnoLessThanOrEqualTo(String value) {
            addCriterion("ptf_outcstno <=", value, "ptfOutcstno");
            return (Criteria) this;
        }

        public Criteria andPtfOutcstnoLike(String value) {
            addCriterion("ptf_outcstno like", value, "ptfOutcstno");
            return (Criteria) this;
        }

        public Criteria andPtfOutcstnoNotLike(String value) {
            addCriterion("ptf_outcstno not like", value, "ptfOutcstno");
            return (Criteria) this;
        }

        public Criteria andPtfOutcstnoIn(List<String> values) {
            addCriterion("ptf_outcstno in", values, "ptfOutcstno");
            return (Criteria) this;
        }

        public Criteria andPtfOutcstnoNotIn(List<String> values) {
            addCriterion("ptf_outcstno not in", values, "ptfOutcstno");
            return (Criteria) this;
        }

        public Criteria andPtfOutcstnoBetween(String value1, String value2) {
            addCriterion("ptf_outcstno between", value1, value2, "ptfOutcstno");
            return (Criteria) this;
        }

        public Criteria andPtfOutcstnoNotBetween(String value1, String value2) {
            addCriterion("ptf_outcstno not between", value1, value2, "ptfOutcstno");
            return (Criteria) this;
        }

        public Criteria andPtfOutcsttypeIsNull() {
            addCriterion("ptf_outcsttype is null");
            return (Criteria) this;
        }

        public Criteria andPtfOutcsttypeIsNotNull() {
            addCriterion("ptf_outcsttype is not null");
            return (Criteria) this;
        }

        public Criteria andPtfOutcsttypeEqualTo(String value) {
            addCriterion("ptf_outcsttype =", value, "ptfOutcsttype");
            return (Criteria) this;
        }

        public Criteria andPtfOutcsttypeNotEqualTo(String value) {
            addCriterion("ptf_outcsttype <>", value, "ptfOutcsttype");
            return (Criteria) this;
        }

        public Criteria andPtfOutcsttypeGreaterThan(String value) {
            addCriterion("ptf_outcsttype >", value, "ptfOutcsttype");
            return (Criteria) this;
        }

        public Criteria andPtfOutcsttypeGreaterThanOrEqualTo(String value) {
            addCriterion("ptf_outcsttype >=", value, "ptfOutcsttype");
            return (Criteria) this;
        }

        public Criteria andPtfOutcsttypeLessThan(String value) {
            addCriterion("ptf_outcsttype <", value, "ptfOutcsttype");
            return (Criteria) this;
        }

        public Criteria andPtfOutcsttypeLessThanOrEqualTo(String value) {
            addCriterion("ptf_outcsttype <=", value, "ptfOutcsttype");
            return (Criteria) this;
        }

        public Criteria andPtfOutcsttypeLike(String value) {
            addCriterion("ptf_outcsttype like", value, "ptfOutcsttype");
            return (Criteria) this;
        }

        public Criteria andPtfOutcsttypeNotLike(String value) {
            addCriterion("ptf_outcsttype not like", value, "ptfOutcsttype");
            return (Criteria) this;
        }

        public Criteria andPtfOutcsttypeIn(List<String> values) {
            addCriterion("ptf_outcsttype in", values, "ptfOutcsttype");
            return (Criteria) this;
        }

        public Criteria andPtfOutcsttypeNotIn(List<String> values) {
            addCriterion("ptf_outcsttype not in", values, "ptfOutcsttype");
            return (Criteria) this;
        }

        public Criteria andPtfOutcsttypeBetween(String value1, String value2) {
            addCriterion("ptf_outcsttype between", value1, value2, "ptfOutcsttype");
            return (Criteria) this;
        }

        public Criteria andPtfOutcsttypeNotBetween(String value1, String value2) {
            addCriterion("ptf_outcsttype not between", value1, value2, "ptfOutcsttype");
            return (Criteria) this;
        }

        public Criteria andPtfOutpayaccIsNull() {
            addCriterion("ptf_outpayacc is null");
            return (Criteria) this;
        }

        public Criteria andPtfOutpayaccIsNotNull() {
            addCriterion("ptf_outpayacc is not null");
            return (Criteria) this;
        }

        public Criteria andPtfOutpayaccEqualTo(String value) {
            addCriterion("ptf_outpayacc =", value, "ptfOutpayacc");
            return (Criteria) this;
        }

        public Criteria andPtfOutpayaccNotEqualTo(String value) {
            addCriterion("ptf_outpayacc <>", value, "ptfOutpayacc");
            return (Criteria) this;
        }

        public Criteria andPtfOutpayaccGreaterThan(String value) {
            addCriterion("ptf_outpayacc >", value, "ptfOutpayacc");
            return (Criteria) this;
        }

        public Criteria andPtfOutpayaccGreaterThanOrEqualTo(String value) {
            addCriterion("ptf_outpayacc >=", value, "ptfOutpayacc");
            return (Criteria) this;
        }

        public Criteria andPtfOutpayaccLessThan(String value) {
            addCriterion("ptf_outpayacc <", value, "ptfOutpayacc");
            return (Criteria) this;
        }

        public Criteria andPtfOutpayaccLessThanOrEqualTo(String value) {
            addCriterion("ptf_outpayacc <=", value, "ptfOutpayacc");
            return (Criteria) this;
        }

        public Criteria andPtfOutpayaccLike(String value) {
            addCriterion("ptf_outpayacc like", value, "ptfOutpayacc");
            return (Criteria) this;
        }

        public Criteria andPtfOutpayaccNotLike(String value) {
            addCriterion("ptf_outpayacc not like", value, "ptfOutpayacc");
            return (Criteria) this;
        }

        public Criteria andPtfOutpayaccIn(List<String> values) {
            addCriterion("ptf_outpayacc in", values, "ptfOutpayacc");
            return (Criteria) this;
        }

        public Criteria andPtfOutpayaccNotIn(List<String> values) {
            addCriterion("ptf_outpayacc not in", values, "ptfOutpayacc");
            return (Criteria) this;
        }

        public Criteria andPtfOutpayaccBetween(String value1, String value2) {
            addCriterion("ptf_outpayacc between", value1, value2, "ptfOutpayacc");
            return (Criteria) this;
        }

        public Criteria andPtfOutpayaccNotBetween(String value1, String value2) {
            addCriterion("ptf_outpayacc not between", value1, value2, "ptfOutpayacc");
            return (Criteria) this;
        }

        public Criteria andPtfOutpayaccfeeIsNull() {
            addCriterion("ptf_outpayaccfee is null");
            return (Criteria) this;
        }

        public Criteria andPtfOutpayaccfeeIsNotNull() {
            addCriterion("ptf_outpayaccfee is not null");
            return (Criteria) this;
        }

        public Criteria andPtfOutpayaccfeeEqualTo(BigDecimal value) {
            addCriterion("ptf_outpayaccfee =", value, "ptfOutpayaccfee");
            return (Criteria) this;
        }

        public Criteria andPtfOutpayaccfeeNotEqualTo(BigDecimal value) {
            addCriterion("ptf_outpayaccfee <>", value, "ptfOutpayaccfee");
            return (Criteria) this;
        }

        public Criteria andPtfOutpayaccfeeGreaterThan(BigDecimal value) {
            addCriterion("ptf_outpayaccfee >", value, "ptfOutpayaccfee");
            return (Criteria) this;
        }

        public Criteria andPtfOutpayaccfeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ptf_outpayaccfee >=", value, "ptfOutpayaccfee");
            return (Criteria) this;
        }

        public Criteria andPtfOutpayaccfeeLessThan(BigDecimal value) {
            addCriterion("ptf_outpayaccfee <", value, "ptfOutpayaccfee");
            return (Criteria) this;
        }

        public Criteria andPtfOutpayaccfeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ptf_outpayaccfee <=", value, "ptfOutpayaccfee");
            return (Criteria) this;
        }

        public Criteria andPtfOutpayaccfeeIn(List<BigDecimal> values) {
            addCriterion("ptf_outpayaccfee in", values, "ptfOutpayaccfee");
            return (Criteria) this;
        }

        public Criteria andPtfOutpayaccfeeNotIn(List<BigDecimal> values) {
            addCriterion("ptf_outpayaccfee not in", values, "ptfOutpayaccfee");
            return (Criteria) this;
        }

        public Criteria andPtfOutpayaccfeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ptf_outpayaccfee between", value1, value2, "ptfOutpayaccfee");
            return (Criteria) this;
        }

        public Criteria andPtfOutpayaccfeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ptf_outpayaccfee not between", value1, value2, "ptfOutpayaccfee");
            return (Criteria) this;
        }

        public Criteria andPtfIntcsttypeIsNull() {
            addCriterion("ptf_intcsttype is null");
            return (Criteria) this;
        }

        public Criteria andPtfIntcsttypeIsNotNull() {
            addCriterion("ptf_intcsttype is not null");
            return (Criteria) this;
        }

        public Criteria andPtfIntcsttypeEqualTo(String value) {
            addCriterion("ptf_intcsttype =", value, "ptfIntcsttype");
            return (Criteria) this;
        }

        public Criteria andPtfIntcsttypeNotEqualTo(String value) {
            addCriterion("ptf_intcsttype <>", value, "ptfIntcsttype");
            return (Criteria) this;
        }

        public Criteria andPtfIntcsttypeGreaterThan(String value) {
            addCriterion("ptf_intcsttype >", value, "ptfIntcsttype");
            return (Criteria) this;
        }

        public Criteria andPtfIntcsttypeGreaterThanOrEqualTo(String value) {
            addCriterion("ptf_intcsttype >=", value, "ptfIntcsttype");
            return (Criteria) this;
        }

        public Criteria andPtfIntcsttypeLessThan(String value) {
            addCriterion("ptf_intcsttype <", value, "ptfIntcsttype");
            return (Criteria) this;
        }

        public Criteria andPtfIntcsttypeLessThanOrEqualTo(String value) {
            addCriterion("ptf_intcsttype <=", value, "ptfIntcsttype");
            return (Criteria) this;
        }

        public Criteria andPtfIntcsttypeLike(String value) {
            addCriterion("ptf_intcsttype like", value, "ptfIntcsttype");
            return (Criteria) this;
        }

        public Criteria andPtfIntcsttypeNotLike(String value) {
            addCriterion("ptf_intcsttype not like", value, "ptfIntcsttype");
            return (Criteria) this;
        }

        public Criteria andPtfIntcsttypeIn(List<String> values) {
            addCriterion("ptf_intcsttype in", values, "ptfIntcsttype");
            return (Criteria) this;
        }

        public Criteria andPtfIntcsttypeNotIn(List<String> values) {
            addCriterion("ptf_intcsttype not in", values, "ptfIntcsttype");
            return (Criteria) this;
        }

        public Criteria andPtfIntcsttypeBetween(String value1, String value2) {
            addCriterion("ptf_intcsttype between", value1, value2, "ptfIntcsttype");
            return (Criteria) this;
        }

        public Criteria andPtfIntcsttypeNotBetween(String value1, String value2) {
            addCriterion("ptf_intcsttype not between", value1, value2, "ptfIntcsttype");
            return (Criteria) this;
        }

        public Criteria andPtfInpayaccIsNull() {
            addCriterion("ptf_inpayacc is null");
            return (Criteria) this;
        }

        public Criteria andPtfInpayaccIsNotNull() {
            addCriterion("ptf_inpayacc is not null");
            return (Criteria) this;
        }

        public Criteria andPtfInpayaccEqualTo(String value) {
            addCriterion("ptf_inpayacc =", value, "ptfInpayacc");
            return (Criteria) this;
        }

        public Criteria andPtfInpayaccNotEqualTo(String value) {
            addCriterion("ptf_inpayacc <>", value, "ptfInpayacc");
            return (Criteria) this;
        }

        public Criteria andPtfInpayaccGreaterThan(String value) {
            addCriterion("ptf_inpayacc >", value, "ptfInpayacc");
            return (Criteria) this;
        }

        public Criteria andPtfInpayaccGreaterThanOrEqualTo(String value) {
            addCriterion("ptf_inpayacc >=", value, "ptfInpayacc");
            return (Criteria) this;
        }

        public Criteria andPtfInpayaccLessThan(String value) {
            addCriterion("ptf_inpayacc <", value, "ptfInpayacc");
            return (Criteria) this;
        }

        public Criteria andPtfInpayaccLessThanOrEqualTo(String value) {
            addCriterion("ptf_inpayacc <=", value, "ptfInpayacc");
            return (Criteria) this;
        }

        public Criteria andPtfInpayaccLike(String value) {
            addCriterion("ptf_inpayacc like", value, "ptfInpayacc");
            return (Criteria) this;
        }

        public Criteria andPtfInpayaccNotLike(String value) {
            addCriterion("ptf_inpayacc not like", value, "ptfInpayacc");
            return (Criteria) this;
        }

        public Criteria andPtfInpayaccIn(List<String> values) {
            addCriterion("ptf_inpayacc in", values, "ptfInpayacc");
            return (Criteria) this;
        }

        public Criteria andPtfInpayaccNotIn(List<String> values) {
            addCriterion("ptf_inpayacc not in", values, "ptfInpayacc");
            return (Criteria) this;
        }

        public Criteria andPtfInpayaccBetween(String value1, String value2) {
            addCriterion("ptf_inpayacc between", value1, value2, "ptfInpayacc");
            return (Criteria) this;
        }

        public Criteria andPtfInpayaccNotBetween(String value1, String value2) {
            addCriterion("ptf_inpayacc not between", value1, value2, "ptfInpayacc");
            return (Criteria) this;
        }

        public Criteria andPtfInpayaccfeeIsNull() {
            addCriterion("ptf_inpayaccfee is null");
            return (Criteria) this;
        }

        public Criteria andPtfInpayaccfeeIsNotNull() {
            addCriterion("ptf_inpayaccfee is not null");
            return (Criteria) this;
        }

        public Criteria andPtfInpayaccfeeEqualTo(BigDecimal value) {
            addCriterion("ptf_inpayaccfee =", value, "ptfInpayaccfee");
            return (Criteria) this;
        }

        public Criteria andPtfInpayaccfeeNotEqualTo(BigDecimal value) {
            addCriterion("ptf_inpayaccfee <>", value, "ptfInpayaccfee");
            return (Criteria) this;
        }

        public Criteria andPtfInpayaccfeeGreaterThan(BigDecimal value) {
            addCriterion("ptf_inpayaccfee >", value, "ptfInpayaccfee");
            return (Criteria) this;
        }

        public Criteria andPtfInpayaccfeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ptf_inpayaccfee >=", value, "ptfInpayaccfee");
            return (Criteria) this;
        }

        public Criteria andPtfInpayaccfeeLessThan(BigDecimal value) {
            addCriterion("ptf_inpayaccfee <", value, "ptfInpayaccfee");
            return (Criteria) this;
        }

        public Criteria andPtfInpayaccfeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ptf_inpayaccfee <=", value, "ptfInpayaccfee");
            return (Criteria) this;
        }

        public Criteria andPtfInpayaccfeeIn(List<BigDecimal> values) {
            addCriterion("ptf_inpayaccfee in", values, "ptfInpayaccfee");
            return (Criteria) this;
        }

        public Criteria andPtfInpayaccfeeNotIn(List<BigDecimal> values) {
            addCriterion("ptf_inpayaccfee not in", values, "ptfInpayaccfee");
            return (Criteria) this;
        }

        public Criteria andPtfInpayaccfeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ptf_inpayaccfee between", value1, value2, "ptfInpayaccfee");
            return (Criteria) this;
        }

        public Criteria andPtfInpayaccfeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ptf_inpayaccfee not between", value1, value2, "ptfInpayaccfee");
            return (Criteria) this;
        }

        public Criteria andPtfTranamtIsNull() {
            addCriterion("ptf_tranamt is null");
            return (Criteria) this;
        }

        public Criteria andPtfTranamtIsNotNull() {
            addCriterion("ptf_tranamt is not null");
            return (Criteria) this;
        }

        public Criteria andPtfTranamtEqualTo(BigDecimal value) {
            addCriterion("ptf_tranamt =", value, "ptfTranamt");
            return (Criteria) this;
        }

        public Criteria andPtfTranamtNotEqualTo(BigDecimal value) {
            addCriterion("ptf_tranamt <>", value, "ptfTranamt");
            return (Criteria) this;
        }

        public Criteria andPtfTranamtGreaterThan(BigDecimal value) {
            addCriterion("ptf_tranamt >", value, "ptfTranamt");
            return (Criteria) this;
        }

        public Criteria andPtfTranamtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ptf_tranamt >=", value, "ptfTranamt");
            return (Criteria) this;
        }

        public Criteria andPtfTranamtLessThan(BigDecimal value) {
            addCriterion("ptf_tranamt <", value, "ptfTranamt");
            return (Criteria) this;
        }

        public Criteria andPtfTranamtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ptf_tranamt <=", value, "ptfTranamt");
            return (Criteria) this;
        }

        public Criteria andPtfTranamtIn(List<BigDecimal> values) {
            addCriterion("ptf_tranamt in", values, "ptfTranamt");
            return (Criteria) this;
        }

        public Criteria andPtfTranamtNotIn(List<BigDecimal> values) {
            addCriterion("ptf_tranamt not in", values, "ptfTranamt");
            return (Criteria) this;
        }

        public Criteria andPtfTranamtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ptf_tranamt between", value1, value2, "ptfTranamt");
            return (Criteria) this;
        }

        public Criteria andPtfTranamtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ptf_tranamt not between", value1, value2, "ptfTranamt");
            return (Criteria) this;
        }

        public Criteria andPtfTranstimeIsNull() {
            addCriterion("ptf_transTime is null");
            return (Criteria) this;
        }

        public Criteria andPtfTranstimeIsNotNull() {
            addCriterion("ptf_transTime is not null");
            return (Criteria) this;
        }

        public Criteria andPtfTranstimeEqualTo(Date value) {
            addCriterion("ptf_transTime =", value, "ptfTranstime");
            return (Criteria) this;
        }

        public Criteria andPtfTranstimeNotEqualTo(Date value) {
            addCriterion("ptf_transTime <>", value, "ptfTranstime");
            return (Criteria) this;
        }

        public Criteria andPtfTranstimeGreaterThan(Date value) {
            addCriterion("ptf_transTime >", value, "ptfTranstime");
            return (Criteria) this;
        }

        public Criteria andPtfTranstimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ptf_transTime >=", value, "ptfTranstime");
            return (Criteria) this;
        }

        public Criteria andPtfTranstimeLessThan(Date value) {
            addCriterion("ptf_transTime <", value, "ptfTranstime");
            return (Criteria) this;
        }

        public Criteria andPtfTranstimeLessThanOrEqualTo(Date value) {
            addCriterion("ptf_transTime <=", value, "ptfTranstime");
            return (Criteria) this;
        }

        public Criteria andPtfTranstimeIn(List<Date> values) {
            addCriterion("ptf_transTime in", values, "ptfTranstime");
            return (Criteria) this;
        }

        public Criteria andPtfTranstimeNotIn(List<Date> values) {
            addCriterion("ptf_transTime not in", values, "ptfTranstime");
            return (Criteria) this;
        }

        public Criteria andPtfTranstimeBetween(Date value1, Date value2) {
            addCriterion("ptf_transTime between", value1, value2, "ptfTranstime");
            return (Criteria) this;
        }

        public Criteria andPtfTranstimeNotBetween(Date value1, Date value2) {
            addCriterion("ptf_transTime not between", value1, value2, "ptfTranstime");
            return (Criteria) this;
        }

        public Criteria andPtfLoannoIsNull() {
            addCriterion("ptf_loanNo is null");
            return (Criteria) this;
        }

        public Criteria andPtfLoannoIsNotNull() {
            addCriterion("ptf_loanNo is not null");
            return (Criteria) this;
        }

        public Criteria andPtfLoannoEqualTo(String value) {
            addCriterion("ptf_loanNo =", value, "ptfLoanno");
            return (Criteria) this;
        }

        public Criteria andPtfLoannoNotEqualTo(String value) {
            addCriterion("ptf_loanNo <>", value, "ptfLoanno");
            return (Criteria) this;
        }

        public Criteria andPtfLoannoGreaterThan(String value) {
            addCriterion("ptf_loanNo >", value, "ptfLoanno");
            return (Criteria) this;
        }

        public Criteria andPtfLoannoGreaterThanOrEqualTo(String value) {
            addCriterion("ptf_loanNo >=", value, "ptfLoanno");
            return (Criteria) this;
        }

        public Criteria andPtfLoannoLessThan(String value) {
            addCriterion("ptf_loanNo <", value, "ptfLoanno");
            return (Criteria) this;
        }

        public Criteria andPtfLoannoLessThanOrEqualTo(String value) {
            addCriterion("ptf_loanNo <=", value, "ptfLoanno");
            return (Criteria) this;
        }

        public Criteria andPtfLoannoLike(String value) {
            addCriterion("ptf_loanNo like", value, "ptfLoanno");
            return (Criteria) this;
        }

        public Criteria andPtfLoannoNotLike(String value) {
            addCriterion("ptf_loanNo not like", value, "ptfLoanno");
            return (Criteria) this;
        }

        public Criteria andPtfLoannoIn(List<String> values) {
            addCriterion("ptf_loanNo in", values, "ptfLoanno");
            return (Criteria) this;
        }

        public Criteria andPtfLoannoNotIn(List<String> values) {
            addCriterion("ptf_loanNo not in", values, "ptfLoanno");
            return (Criteria) this;
        }

        public Criteria andPtfLoannoBetween(String value1, String value2) {
            addCriterion("ptf_loanNo between", value1, value2, "ptfLoanno");
            return (Criteria) this;
        }

        public Criteria andPtfLoannoNotBetween(String value1, String value2) {
            addCriterion("ptf_loanNo not between", value1, value2, "ptfLoanno");
            return (Criteria) this;
        }

        public Criteria andPtfTenderflownoIsNull() {
            addCriterion("ptf_tenderFlowNo is null");
            return (Criteria) this;
        }

        public Criteria andPtfTenderflownoIsNotNull() {
            addCriterion("ptf_tenderFlowNo is not null");
            return (Criteria) this;
        }

        public Criteria andPtfTenderflownoEqualTo(String value) {
            addCriterion("ptf_tenderFlowNo =", value, "ptfTenderflowno");
            return (Criteria) this;
        }

        public Criteria andPtfTenderflownoNotEqualTo(String value) {
            addCriterion("ptf_tenderFlowNo <>", value, "ptfTenderflowno");
            return (Criteria) this;
        }

        public Criteria andPtfTenderflownoGreaterThan(String value) {
            addCriterion("ptf_tenderFlowNo >", value, "ptfTenderflowno");
            return (Criteria) this;
        }

        public Criteria andPtfTenderflownoGreaterThanOrEqualTo(String value) {
            addCriterion("ptf_tenderFlowNo >=", value, "ptfTenderflowno");
            return (Criteria) this;
        }

        public Criteria andPtfTenderflownoLessThan(String value) {
            addCriterion("ptf_tenderFlowNo <", value, "ptfTenderflowno");
            return (Criteria) this;
        }

        public Criteria andPtfTenderflownoLessThanOrEqualTo(String value) {
            addCriterion("ptf_tenderFlowNo <=", value, "ptfTenderflowno");
            return (Criteria) this;
        }

        public Criteria andPtfTenderflownoLike(String value) {
            addCriterion("ptf_tenderFlowNo like", value, "ptfTenderflowno");
            return (Criteria) this;
        }

        public Criteria andPtfTenderflownoNotLike(String value) {
            addCriterion("ptf_tenderFlowNo not like", value, "ptfTenderflowno");
            return (Criteria) this;
        }

        public Criteria andPtfTenderflownoIn(List<String> values) {
            addCriterion("ptf_tenderFlowNo in", values, "ptfTenderflowno");
            return (Criteria) this;
        }

        public Criteria andPtfTenderflownoNotIn(List<String> values) {
            addCriterion("ptf_tenderFlowNo not in", values, "ptfTenderflowno");
            return (Criteria) this;
        }

        public Criteria andPtfTenderflownoBetween(String value1, String value2) {
            addCriterion("ptf_tenderFlowNo between", value1, value2, "ptfTenderflowno");
            return (Criteria) this;
        }

        public Criteria andPtfTenderflownoNotBetween(String value1, String value2) {
            addCriterion("ptf_tenderFlowNo not between", value1, value2, "ptfTenderflowno");
            return (Criteria) this;
        }

        public Criteria andPtfHostResponseTimeIsNull() {
            addCriterion("ptf_host_response_time is null");
            return (Criteria) this;
        }

        public Criteria andPtfHostResponseTimeIsNotNull() {
            addCriterion("ptf_host_response_time is not null");
            return (Criteria) this;
        }

        public Criteria andPtfHostResponseTimeEqualTo(Date value) {
            addCriterion("ptf_host_response_time =", value, "ptfHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPtfHostResponseTimeNotEqualTo(Date value) {
            addCriterion("ptf_host_response_time <>", value, "ptfHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPtfHostResponseTimeGreaterThan(Date value) {
            addCriterion("ptf_host_response_time >", value, "ptfHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPtfHostResponseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ptf_host_response_time >=", value, "ptfHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPtfHostResponseTimeLessThan(Date value) {
            addCriterion("ptf_host_response_time <", value, "ptfHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPtfHostResponseTimeLessThanOrEqualTo(Date value) {
            addCriterion("ptf_host_response_time <=", value, "ptfHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPtfHostResponseTimeIn(List<Date> values) {
            addCriterion("ptf_host_response_time in", values, "ptfHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPtfHostResponseTimeNotIn(List<Date> values) {
            addCriterion("ptf_host_response_time not in", values, "ptfHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPtfHostResponseTimeBetween(Date value1, Date value2) {
            addCriterion("ptf_host_response_time between", value1, value2, "ptfHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPtfHostResponseTimeNotBetween(Date value1, Date value2) {
            addCriterion("ptf_host_response_time not between", value1, value2, "ptfHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPtfHostResponseFlownumIsNull() {
            addCriterion("ptf_host_response_flowNum is null");
            return (Criteria) this;
        }

        public Criteria andPtfHostResponseFlownumIsNotNull() {
            addCriterion("ptf_host_response_flowNum is not null");
            return (Criteria) this;
        }

        public Criteria andPtfHostResponseFlownumEqualTo(String value) {
            addCriterion("ptf_host_response_flowNum =", value, "ptfHostResponseFlownum");
            return (Criteria) this;
        }

        public Criteria andPtfHostResponseFlownumNotEqualTo(String value) {
            addCriterion("ptf_host_response_flowNum <>", value, "ptfHostResponseFlownum");
            return (Criteria) this;
        }

        public Criteria andPtfHostResponseFlownumGreaterThan(String value) {
            addCriterion("ptf_host_response_flowNum >", value, "ptfHostResponseFlownum");
            return (Criteria) this;
        }

        public Criteria andPtfHostResponseFlownumGreaterThanOrEqualTo(String value) {
            addCriterion("ptf_host_response_flowNum >=", value, "ptfHostResponseFlownum");
            return (Criteria) this;
        }

        public Criteria andPtfHostResponseFlownumLessThan(String value) {
            addCriterion("ptf_host_response_flowNum <", value, "ptfHostResponseFlownum");
            return (Criteria) this;
        }

        public Criteria andPtfHostResponseFlownumLessThanOrEqualTo(String value) {
            addCriterion("ptf_host_response_flowNum <=", value, "ptfHostResponseFlownum");
            return (Criteria) this;
        }

        public Criteria andPtfHostResponseFlownumLike(String value) {
            addCriterion("ptf_host_response_flowNum like", value, "ptfHostResponseFlownum");
            return (Criteria) this;
        }

        public Criteria andPtfHostResponseFlownumNotLike(String value) {
            addCriterion("ptf_host_response_flowNum not like", value, "ptfHostResponseFlownum");
            return (Criteria) this;
        }

        public Criteria andPtfHostResponseFlownumIn(List<String> values) {
            addCriterion("ptf_host_response_flowNum in", values, "ptfHostResponseFlownum");
            return (Criteria) this;
        }

        public Criteria andPtfHostResponseFlownumNotIn(List<String> values) {
            addCriterion("ptf_host_response_flowNum not in", values, "ptfHostResponseFlownum");
            return (Criteria) this;
        }

        public Criteria andPtfHostResponseFlownumBetween(String value1, String value2) {
            addCriterion("ptf_host_response_flowNum between", value1, value2, "ptfHostResponseFlownum");
            return (Criteria) this;
        }

        public Criteria andPtfHostResponseFlownumNotBetween(String value1, String value2) {
            addCriterion("ptf_host_response_flowNum not between", value1, value2, "ptfHostResponseFlownum");
            return (Criteria) this;
        }

        public Criteria andPtfHostReturnCodeIsNull() {
            addCriterion("ptf_host_return_code is null");
            return (Criteria) this;
        }

        public Criteria andPtfHostReturnCodeIsNotNull() {
            addCriterion("ptf_host_return_code is not null");
            return (Criteria) this;
        }

        public Criteria andPtfHostReturnCodeEqualTo(String value) {
            addCriterion("ptf_host_return_code =", value, "ptfHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPtfHostReturnCodeNotEqualTo(String value) {
            addCriterion("ptf_host_return_code <>", value, "ptfHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPtfHostReturnCodeGreaterThan(String value) {
            addCriterion("ptf_host_return_code >", value, "ptfHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPtfHostReturnCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ptf_host_return_code >=", value, "ptfHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPtfHostReturnCodeLessThan(String value) {
            addCriterion("ptf_host_return_code <", value, "ptfHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPtfHostReturnCodeLessThanOrEqualTo(String value) {
            addCriterion("ptf_host_return_code <=", value, "ptfHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPtfHostReturnCodeLike(String value) {
            addCriterion("ptf_host_return_code like", value, "ptfHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPtfHostReturnCodeNotLike(String value) {
            addCriterion("ptf_host_return_code not like", value, "ptfHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPtfHostReturnCodeIn(List<String> values) {
            addCriterion("ptf_host_return_code in", values, "ptfHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPtfHostReturnCodeNotIn(List<String> values) {
            addCriterion("ptf_host_return_code not in", values, "ptfHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPtfHostReturnCodeBetween(String value1, String value2) {
            addCriterion("ptf_host_return_code between", value1, value2, "ptfHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPtfHostReturnCodeNotBetween(String value1, String value2) {
            addCriterion("ptf_host_return_code not between", value1, value2, "ptfHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPtfHostReturnMessageIsNull() {
            addCriterion("ptf_host_return_message is null");
            return (Criteria) this;
        }

        public Criteria andPtfHostReturnMessageIsNotNull() {
            addCriterion("ptf_host_return_message is not null");
            return (Criteria) this;
        }

        public Criteria andPtfHostReturnMessageEqualTo(String value) {
            addCriterion("ptf_host_return_message =", value, "ptfHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPtfHostReturnMessageNotEqualTo(String value) {
            addCriterion("ptf_host_return_message <>", value, "ptfHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPtfHostReturnMessageGreaterThan(String value) {
            addCriterion("ptf_host_return_message >", value, "ptfHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPtfHostReturnMessageGreaterThanOrEqualTo(String value) {
            addCriterion("ptf_host_return_message >=", value, "ptfHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPtfHostReturnMessageLessThan(String value) {
            addCriterion("ptf_host_return_message <", value, "ptfHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPtfHostReturnMessageLessThanOrEqualTo(String value) {
            addCriterion("ptf_host_return_message <=", value, "ptfHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPtfHostReturnMessageLike(String value) {
            addCriterion("ptf_host_return_message like", value, "ptfHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPtfHostReturnMessageNotLike(String value) {
            addCriterion("ptf_host_return_message not like", value, "ptfHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPtfHostReturnMessageIn(List<String> values) {
            addCriterion("ptf_host_return_message in", values, "ptfHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPtfHostReturnMessageNotIn(List<String> values) {
            addCriterion("ptf_host_return_message not in", values, "ptfHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPtfHostReturnMessageBetween(String value1, String value2) {
            addCriterion("ptf_host_return_message between", value1, value2, "ptfHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPtfHostReturnMessageNotBetween(String value1, String value2) {
            addCriterion("ptf_host_return_message not between", value1, value2, "ptfHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPtfPaystatusIsNull() {
            addCriterion("ptf_payStatus is null");
            return (Criteria) this;
        }

        public Criteria andPtfPaystatusIsNotNull() {
            addCriterion("ptf_payStatus is not null");
            return (Criteria) this;
        }

        public Criteria andPtfPaystatusEqualTo(String value) {
            addCriterion("ptf_payStatus =", value, "ptfPaystatus");
            return (Criteria) this;
        }

        public Criteria andPtfPaystatusNotEqualTo(String value) {
            addCriterion("ptf_payStatus <>", value, "ptfPaystatus");
            return (Criteria) this;
        }

        public Criteria andPtfPaystatusGreaterThan(String value) {
            addCriterion("ptf_payStatus >", value, "ptfPaystatus");
            return (Criteria) this;
        }

        public Criteria andPtfPaystatusGreaterThanOrEqualTo(String value) {
            addCriterion("ptf_payStatus >=", value, "ptfPaystatus");
            return (Criteria) this;
        }

        public Criteria andPtfPaystatusLessThan(String value) {
            addCriterion("ptf_payStatus <", value, "ptfPaystatus");
            return (Criteria) this;
        }

        public Criteria andPtfPaystatusLessThanOrEqualTo(String value) {
            addCriterion("ptf_payStatus <=", value, "ptfPaystatus");
            return (Criteria) this;
        }

        public Criteria andPtfPaystatusLike(String value) {
            addCriterion("ptf_payStatus like", value, "ptfPaystatus");
            return (Criteria) this;
        }

        public Criteria andPtfPaystatusNotLike(String value) {
            addCriterion("ptf_payStatus not like", value, "ptfPaystatus");
            return (Criteria) this;
        }

        public Criteria andPtfPaystatusIn(List<String> values) {
            addCriterion("ptf_payStatus in", values, "ptfPaystatus");
            return (Criteria) this;
        }

        public Criteria andPtfPaystatusNotIn(List<String> values) {
            addCriterion("ptf_payStatus not in", values, "ptfPaystatus");
            return (Criteria) this;
        }

        public Criteria andPtfPaystatusBetween(String value1, String value2) {
            addCriterion("ptf_payStatus between", value1, value2, "ptfPaystatus");
            return (Criteria) this;
        }

        public Criteria andPtfPaystatusNotBetween(String value1, String value2) {
            addCriterion("ptf_payStatus not between", value1, value2, "ptfPaystatus");
            return (Criteria) this;
        }

        public Criteria andPtfRemarkIsNull() {
            addCriterion("ptf_remark is null");
            return (Criteria) this;
        }

        public Criteria andPtfRemarkIsNotNull() {
            addCriterion("ptf_remark is not null");
            return (Criteria) this;
        }

        public Criteria andPtfRemarkEqualTo(String value) {
            addCriterion("ptf_remark =", value, "ptfRemark");
            return (Criteria) this;
        }

        public Criteria andPtfRemarkNotEqualTo(String value) {
            addCriterion("ptf_remark <>", value, "ptfRemark");
            return (Criteria) this;
        }

        public Criteria andPtfRemarkGreaterThan(String value) {
            addCriterion("ptf_remark >", value, "ptfRemark");
            return (Criteria) this;
        }

        public Criteria andPtfRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("ptf_remark >=", value, "ptfRemark");
            return (Criteria) this;
        }

        public Criteria andPtfRemarkLessThan(String value) {
            addCriterion("ptf_remark <", value, "ptfRemark");
            return (Criteria) this;
        }

        public Criteria andPtfRemarkLessThanOrEqualTo(String value) {
            addCriterion("ptf_remark <=", value, "ptfRemark");
            return (Criteria) this;
        }

        public Criteria andPtfRemarkLike(String value) {
            addCriterion("ptf_remark like", value, "ptfRemark");
            return (Criteria) this;
        }

        public Criteria andPtfRemarkNotLike(String value) {
            addCriterion("ptf_remark not like", value, "ptfRemark");
            return (Criteria) this;
        }

        public Criteria andPtfRemarkIn(List<String> values) {
            addCriterion("ptf_remark in", values, "ptfRemark");
            return (Criteria) this;
        }

        public Criteria andPtfRemarkNotIn(List<String> values) {
            addCriterion("ptf_remark not in", values, "ptfRemark");
            return (Criteria) this;
        }

        public Criteria andPtfRemarkBetween(String value1, String value2) {
            addCriterion("ptf_remark between", value1, value2, "ptfRemark");
            return (Criteria) this;
        }

        public Criteria andPtfRemarkNotBetween(String value1, String value2) {
            addCriterion("ptf_remark not between", value1, value2, "ptfRemark");
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