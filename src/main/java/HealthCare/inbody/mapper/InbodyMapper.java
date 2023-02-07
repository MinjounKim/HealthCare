package HealthCare.inbody.mapper;

import HealthCare.inbody.dto.PostInbodyDto;
import HealthCare.inbody.dto.ResponseInbodyDto;
import HealthCare.inbody.entity.Inbody;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InbodyMapper {

    Inbody postInbodyDtoToInbody (PostInbodyDto postInbodyDto);

    ResponseInbodyDto inbodyToResponseInbodyDto(Inbody inbody);

    List<ResponseInbodyDto> inbodiesToResponseInbodyDtos (List<Inbody> inbodies);
}
