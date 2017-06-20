package com.baibao.core.exception;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class BusinessException
	extends RuntimeException
	implements Serializable
{
	private static final long serialVersionUID = -5192697952129146419L;

	/**
	 * 该异常的触发异常
	 */
	private Throwable rootCause;

	public BusinessException() {

	}

	public BusinessException(String msg) {
		super(msg);
	}

	public BusinessException(String msg, Throwable rootCause) {
		super(msg);
		this.rootCause = rootCause;
	}

	public BusinessException(Throwable rootCause) {
		this.rootCause = rootCause;
	}

	public Throwable getCause() {
		return rootCause;
	}

	public String getMessage() {
		StringBuffer sb = new StringBuffer();
		String msg = super.getMessage();

		if (msg != null) {
			sb.append(msg);

			if (rootCause != null) {
				sb.append(": ");
			}
		}

		if (rootCause != null) {
			sb.append("root cause: " + ((rootCause.getMessage() == null) ? rootCause.toString() : rootCause.getMessage()));
		}

		return sb.toString();
	}

	public Throwable getRootCause() {
		return rootCause;
	}

	public void printStackTrace() {
		super.printStackTrace();

		if (rootCause != null) {
			synchronized (System.err) {
				System.err.println("\nRoot cause:");
				rootCause.printStackTrace();
			}
		}
	}

	public void printStackTrace(PrintStream s) {
		super.printStackTrace(s);

		if (rootCause != null) {
			synchronized (s) {
				s.println("\nRoot cause:");
				rootCause.printStackTrace(s);
			}
		}
	}

	public void printStackTrace(PrintWriter s) {
		super.printStackTrace(s);

		if (rootCause != null) {
			synchronized (s) {
				s.println("\nRoot cause:");
				rootCause.printStackTrace(s);
			}
		}
	}

	/**
	 * @see java.lang.Comparable#compareTo(Object)
	 */
	public int compareTo(Object object) {
		BusinessException myClass = (BusinessException) object;
		return new CompareToBuilder().append(this.rootCause, myClass.rootCause).toComparison();
	}

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof BusinessException)) {
			return false;
		}
		BusinessException rhs = (BusinessException) object;
		return new EqualsBuilder().appendSuper(super.equals(object)).append(this.rootCause, rhs.rootCause).isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(1121927485, -1311895155).appendSuper(super.hashCode()).append(this.rootCause).toHashCode();
	}
}
