package sec.tyto.sqli_vulnerable_app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import sec.tyto.sqli_vulnerable_app.model.User;
import sec.tyto.sqli_vulnerable_app.model.dto.UserRequest;
import sec.tyto.sqli_vulnerable_app.model.dto.UserResponse;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    User map(UserRequest userRequest);
    UserResponse map(User user);
}
