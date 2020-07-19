package proj.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(value="hibernateLazyInitializer")
@Getter
@Setter
@ToString
@Entity
@EqualsAndHashCode(of="groupCode")
@Table(name="code_group")
public class CodeGroup {
    @Id
    @Column(length = 3)
    private String groupCode;

    @Column(length = 30, nullable = false)
    private String groupName;

    @Column(length = 1)
    private String useYn = "Y";

    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    @CreationTimestamp
    private Date regDate;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    @UpdateTimestamp
    private Date updDate;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name="groupCode")
    private List<CodeDetail> codeDetails;
}