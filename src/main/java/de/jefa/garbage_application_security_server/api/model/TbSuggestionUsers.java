package de.jefa.garbage_application_security_server.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_suggestion_users", schema = "public", catalog = "db_garbage_test")
public class TbSuggestionUsers {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "autoid", nullable = false)
    @JsonIgnore
    private long autoid;

    @Basic
    @Column(name = "username", nullable = false, length = 32)
    private String username;

    @Basic
    @Column(name = "password", nullable = false, length = 64)
    private String password;

    @Basic
    @Column(name = "safety_answer_1", nullable = false, length = 32)
    private String safetyAnswer1;

    @Basic
    @Column(name = "safety_answer_2", nullable = false, length = 32)
    private String safetyAnswer2;

    @Basic
    @Column(name = "safety_answer_3", nullable = false, length = 32)
    private String safetyAnswer3;

    @Basic
    @Column(name = "safety_question_1_ref")
    @JsonIgnore
    private Long safetyQuestion1Ref;

    @Basic
    @Column(name = "safety_question_2_ref")
    @JsonIgnore
    private Long safetyQuestion2Ref;

    @Basic
    @Column(name = "safety_question_3_ref")
    @JsonIgnore
    private Long safetyQuestion3Ref;

    @Basic
    @Column(name = "is_admin_flag")
    private boolean isAdminFlag;

    public long getAutoid() {
        return autoid;
    }

    public void setAutoid(long autoid) {
        this.autoid = autoid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSafetyAnswer1() {
        return safetyAnswer1;
    }

    public void setSafetyAnswer1(String safetyAnswer1) {
        this.safetyAnswer1 = safetyAnswer1;
    }

    public String getSafetyAnswer2() {
        return safetyAnswer2;
    }

    public void setSafetyAnswer2(String safetyAnswer2) {
        this.safetyAnswer2 = safetyAnswer2;
    }

    public String getSafetyAnswer3() {
        return safetyAnswer3;
    }

    public void setSafetyAnswer3(String safetyAnswer3) {
        this.safetyAnswer3 = safetyAnswer3;
    }

    public Long getSafetyQuestion1Ref() {
        return safetyQuestion1Ref;
    }

    public void setSafetyQuestion1Ref(Long safetyQuestion1Ref) {
        this.safetyQuestion1Ref = safetyQuestion1Ref;
    }

    public Long getSafetyQuestion2Ref() {
        return safetyQuestion2Ref;
    }

    public void setSafetyQuestion2Ref(Long safetyQuestion2Ref) {
        this.safetyQuestion2Ref = safetyQuestion2Ref;
    }

    public Long getSafetyQuestion3Ref() {
        return safetyQuestion3Ref;
    }

    public void setSafetyQuestion3Ref(Long safetyQuestion3Ref) {
        this.safetyQuestion3Ref = safetyQuestion3Ref;
    }

    public boolean isAdminFlag() {
        return isAdminFlag;
    }

    public void setAdminFlag(boolean adminFlag) {
        isAdminFlag = adminFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbSuggestionUsers that = (TbSuggestionUsers) o;
        return autoid == that.autoid && Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(safetyAnswer1, that.safetyAnswer1) && Objects.equals(safetyAnswer2, that.safetyAnswer2) && Objects.equals(safetyAnswer3, that.safetyAnswer3) && Objects.equals(safetyQuestion1Ref, that.safetyQuestion1Ref) && Objects.equals(safetyQuestion2Ref, that.safetyQuestion2Ref) && Objects.equals(safetyQuestion3Ref, that.safetyQuestion3Ref);
    }

    @Override
    public int hashCode() {
        return Objects.hash(autoid, username, password, safetyAnswer1, safetyAnswer2, safetyAnswer3, safetyQuestion1Ref, safetyQuestion2Ref, safetyQuestion3Ref);
    }
}
