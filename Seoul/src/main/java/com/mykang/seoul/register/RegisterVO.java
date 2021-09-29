package com.mykang.seoul.register;

public class RegisterVO {
  private String userid;
  private String userpwd;
  private String username;
  /* 연락처 */
  private String tel1;
  private String tel2;
  private String tel3;

  private String tel; // 010-1234-5678

  // 이메일
  private String emailid;
  private String domain;

  private String email; // abcd@nate.com

  private String zipcode;
  private String addr;
  private String addrdetail;

  private String[] hobby; // 체크박스로 만든 값을 배열로 만들어 보낸다.
  private String hobbyStr;
  
  //로그인여부
  private String logStatus="N";
  

  public String getLogStatus() {
	return logStatus;
}

public void setLogStatus(String logStatus) {
	this.logStatus = logStatus;
}

public String getUserid() {
    return userid;
  }

  public void setUserid(String userid) {
    this.userid = userid;
  }

  public String getUserpwd() {
    return userpwd;
  }

  public void setUserpwd(String userpwd) {
    this.userpwd = userpwd;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getTel1() {
    return tel1;
  }

  public void setTel1(String tel1) {
    this.tel1 = tel1;
  }

  public String getTel2() {
    return tel2;
  }

  public void setTel2(String tel2) {
    this.tel2 = tel2;
  }

  public String getTel3() {
    return tel3;
  }

  public void setTel3(String tel3) {
    this.tel3 = tel3;
  }

  public String getTel() {
    tel = tel1 + "-" + tel2 + "-" + tel3;
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;

    // 전화번호 -로 분리하여 tel1, tel2, tel3에 대입한다.
    String t[] = tel.split("-");
    tel1 = t[0];
    tel2 = t[1];
    tel3 = t[2];
  }

  public String getEmailid() {
    return emailid;
  }

  public void setEmailid(String emailid) {
    this.emailid = emailid;
  }

  public String getDomain() {
    return domain;
  }

  public void setDomain(String domain) {
    this.domain = domain;
  }

  public String getEmail() {
    email = emailid + "@" + domain;
    return email;
  }

  public void setEmail(String email) {
    this.email = email;

    // 이메일 @로 분리하여 emailid, domain에 대입한다.
    if(email!=null) {
    	String mail[] = email.split("@");
    	emailid = mail[0];
    	domain = mail[1];
    }
  }

  public String getZipcode() {
    return zipcode;
  }

  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }

  public String getAddr() {
    return addr;
  }

  public void setAddr(String addr) {
    this.addr = addr;
  }

  public String getAddrdetail() {
    return addrdetail;
  }

  public void setAddrdetail(String addrdetail) {
    this.addrdetail = addrdetail;
  }

  public String[] getHobby() {

    return hobby;
  }

  public void setHobby(String[] hobby) {
    this.hobby = hobby;

    // 배열의 데이터를 문자열 저장하기
    hobbyStr = "";
    for (String h : hobby) {
      hobbyStr += h + "/";
    }
  }

  public String getHobbyStr() {
    return hobbyStr;
  }

  public void setHobbyStr(String hobbyStr) {
    this.hobbyStr = hobbyStr;
    
    // 문자열을 배열로 저장
    if(hobbyStr != null) {
    	hobby = hobbyStr.split("/");
    }
  }

}
