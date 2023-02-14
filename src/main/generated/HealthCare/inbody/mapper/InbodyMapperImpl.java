package HealthCare.inbody.mapper;

import HealthCare.inbody.dto.PostInbodyDto;
import HealthCare.inbody.dto.ResponseInbodyDto;
import HealthCare.inbody.entity.Inbody;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-14T17:06:47+0900",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class InbodyMapperImpl implements InbodyMapper {

    @Override
    public Inbody postInbodyDtoToInbody(PostInbodyDto postInbodyDto) {
        if ( postInbodyDto == null ) {
            return null;
        }

        Inbody inbody = new Inbody();

        inbody.setArms( postInbodyDto.getArms() );
        inbody.setLegs( postInbodyDto.getLegs() );
        inbody.setBody( postInbodyDto.getBody() );

        return inbody;
    }

    @Override
    public ResponseInbodyDto inbodyToResponseInbodyDto(Inbody inbody) {
        if ( inbody == null ) {
            return null;
        }

        ResponseInbodyDto.ResponseInbodyDtoBuilder responseInbodyDto = ResponseInbodyDto.builder();

        responseInbodyDto.inbodyId( inbody.getInbodyId() );
        responseInbodyDto.memberId( inbody.getMemberId() );
        responseInbodyDto.memberName( inbody.getMemberName() );
        responseInbodyDto.measurementDate( inbody.getMeasurementDate() );
        responseInbodyDto.arms( inbody.getArms() );
        responseInbodyDto.legs( inbody.getLegs() );
        responseInbodyDto.body( inbody.getBody() );

        return responseInbodyDto.build();
    }

    @Override
    public List<ResponseInbodyDto> inbodiesToResponseInbodyDtos(List<Inbody> inbodies) {
        if ( inbodies == null ) {
            return null;
        }

        List<ResponseInbodyDto> list = new ArrayList<ResponseInbodyDto>( inbodies.size() );
        for ( Inbody inbody : inbodies ) {
            list.add( inbodyToResponseInbodyDto( inbody ) );
        }

        return list;
    }
}
