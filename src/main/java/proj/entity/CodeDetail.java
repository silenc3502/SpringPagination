package proj.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"groupCode", "codeValue"})
@Entity
@IdClass(CodeDetailId.class)
@Table(name="code_detail")
public class CodeDetail {
    @Id
    @Column(length = 3)
    private String groupCode;

    @Id
    @Column(length = 3)
    private String codeValue;

    @Column(length = 30, nullable = false)
    private String codeName;

    private int sortSeq;

    @Column(length = 1)
    private String useYn = "Y";

    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    @CreationTimestamp
    private Date regDate;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    @UpdateTimestamp
    private Date updDate;
}