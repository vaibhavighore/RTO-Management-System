
package code.microsystem.Entity;


import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String email, password;
	private String test,name, dob, age, aadhar, address, mobile, gender, city, state, zip;
	private boolean login;
	@CreationTimestamp
	private LocalDateTime created;
	
	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public boolean isLogin() {
		return login;
	}

	public void setLogin(boolean login) {
		this.login = login;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

		@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", test=" + test + ", name=" + name
				+ ", dob=" + dob + ", age=" + age + ", aadhar=" + aadhar + ", address=" + address + ", mobile=" + mobile
				+ ", gender=" + gender + ", city=" + city + ", state=" + state + ", zip=" + zip + "]";
	}

		public User() {
		super();
	}

		public User(String email, String password, String test, String name, String dob, String age,
				String aadhar, String address, String mobile, String gender, String city, String state, String zip,
				boolean login) {
			super();

			this.email = email;
			this.password = password;
			this.test = test;
			this.name = name;
			this.dob = dob;
			this.age = age;
			this.aadhar = aadhar;
			this.address = address;
			this.mobile = mobile;
			this.gender = gender;
			this.city = city;
			this.state = state;
			this.zip = zip;
			this.login = login;
			
		}

}
