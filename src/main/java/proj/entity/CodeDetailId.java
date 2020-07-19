package proj.entity;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of= {"groupCode", "codeValue"})
@ToString
public class CodeDetailId implements Serializable {
    private static final long serialVersionUID = 1L;

    private String groupCode;
    private String codeValue;
}