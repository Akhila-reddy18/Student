package com.university.Student.dto;

public class FeeDTO {
	
		
		Integer studentid;
		Double tutionfee;
		Double examfee;
		Double labfee;
		Double yogafee;
		Double sportsfee;
		Double pendingdue;
		
		public Integer getStudentid() {
			return studentid;
		}
		public void setStudentid(Integer studentid) {
			this.studentid = studentid;
		}
		public Double getTutionfee() {
			return tutionfee;
		}
		public void setTutionfee(Double tutionfee) {
			this.tutionfee = tutionfee;
		}
		public Double getExamfee() {
			return examfee;
		}
		public void setExamfee(Double examfee) {
			this.examfee = examfee;
		}
		public Double getLabfee() {
			return labfee;
		}
		public void setLabfee(Double labfee) {
			this.labfee = labfee;
		}
		public Double getYogafee() {
			return yogafee;
		}
		public void setYogafee(Double yogafee) {
			this.yogafee = yogafee;
		}
		public Double getSportsfee() {
			return sportsfee;
		}
		public void setSportsfee(Double sportsfee) {
			this.sportsfee = sportsfee;
		}
		public Double getPendingdue() {
			return pendingdue;
		}
		public void setPendingdue(Double pendingdue) {
			this.pendingdue = pendingdue;
		}

		public FeeDTO() {
			super();
		}
		// Converts Entity into DTO


}
