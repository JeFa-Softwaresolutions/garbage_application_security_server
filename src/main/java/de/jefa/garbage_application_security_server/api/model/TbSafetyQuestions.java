package de.jefa.garbage_application_security_server.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_safety_questions", schema = "public", catalog = "db_garbage_test")
public class TbSafetyQuestions {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "autoid", nullable = false)
    @JsonIgnore
    private long autoid;

    @Basic
    @Column(name = "system_id", nullable = false, length = 8)
    private String systemId;

    @Basic
    @Column(name = "text", nullable = false, length = 128)
    private String text;

    public long getAutoid() {
        return autoid;
    }

    public void setAutoid(long autoid) {
        this.autoid = autoid;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbSafetyQuestions that = (TbSafetyQuestions) o;
        return autoid == that.autoid && Objects.equals(systemId, that.systemId) && Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(autoid, systemId, text);
    }
}
