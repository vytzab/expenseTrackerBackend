/**
 * 
 */
package lt.viko.eif.vytzab.expenseTrackerApi.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Vytautas
 *
 *         Class for the <Expense> entity implementation.
 */
@Entity
@Table(name = "tbl_expenses")
public class Expense {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "expense_name")
	@NotNull(message = "Expense name must not be null")
	@Size(min = 3, message = "Expense name must be at least 3 characters.")
	private String name;

	private String description;

	@Column(name = "expense_amount")
	@NotNull(message = "Expense amount must not be null")
	private BigDecimal amount;

	@NotBlank(message = "Category must not be blank")
	private String category;

	@NotNull(message = "Date must not be null")
	private Date date;

	@Column(name = "created_at", nullable = false, updatable = false)
	@CreationTimestamp
	private Timestamp createdAt;

	@Column(name = "updated_at")
	@UpdateTimestamp
	private Timestamp updatedAt;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private User user;

	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param amount
	 * @param category
	 * @param date
	 * @param createdAt
	 * @param updatedAt
	 * @param user
	 */
	public Expense(Long id,
			@NotNull(message = "Expense name must not be null") @Size(min = 3, message = "Expense name must be at least 3 characters.") String name,
			String description, @NotNull(message = "Expense amount must not be null") BigDecimal amount,
			@NotBlank(message = "Expense category must not be blank") String category,
			@NotNull(message = "Expense date must not be null") Date date, Timestamp createdAt, Timestamp updatedAt,
			User user) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.amount = amount;
		this.category = category;
		this.date = date;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.user = user;
	}

	/**
	 * 
	 */
	public Expense() {
		super();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	@NotNull(message = "Expense name must not be null")
	@Size(min = 3, message = "Expense name must be at least 3 characters.")
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the amount
	 */
	@NotNull(message = "Expense amount must not be null")
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * @return the category
	 */
	@NotBlank(message = "Expense category must not be blank")
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the date
	 */
	@NotNull(message = "Expense date must not be null")
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the createdAt
	 */
	public Timestamp getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the updatedAt
	 */
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Expense [id=" + id + ", name=" + name + ", description=" + description + ", amount=" + amount
				+ ", category=" + category + ", date=" + date + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", user=" + user + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Expense other = (Expense) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}