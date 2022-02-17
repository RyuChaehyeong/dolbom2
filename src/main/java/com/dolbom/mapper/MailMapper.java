package com.dolbom.mapper;

import com.dolbom.domain.MailVO;
import com.dolbom.domain.QuoteReqVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MailMapper {
    String getTemplate(@Param("mailGroupId") String mailGroupId,
                       @Param("atbr") String atbr);

    void registerHist(MailVO mail);

    String getMailSj(@Param("mailGroupId") String mailGroupId,
                       @Param("atbr") String atbr);

    MailVO getMailTemplInfo(@Param("mailGroupId") String mailGroupId,
                            @Param("atbr") String atbr);
}
