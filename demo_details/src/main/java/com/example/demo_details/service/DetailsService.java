package com.example.demo_details.service;

import java.io.File;

import com.example.demo_details.dao.DetailsDAO;
import com.example.demo_details.dto.DetailsDTO;
import com.example.demo_details.repository.DetailsRepository;
import com.example.demo_details.util.CommUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @className DetailsService
 * @mehtod getDetailsInfo
 * @description 아래 예제는 Employee 정보를 관리하는 서비스 Service 입니다.
 */
@Service
public class DetailsService {

    Logger logger = LoggerFactory.getLogger(DetailsService.class);

    @Autowired
    DetailsRepository repository;
    
    /**
     * @methodName  getDetailsInfo
     * @return      DetailsDTO.Response
     * @throws      Exception
     * @description DetailsInfo 정보를 가져오는 Mehtod 입니다.
     */
    public DetailsDTO.Response getDetailsInfo(String prodCode) throws Exception{

        DetailsDTO.Response response = new DetailsDTO.Response();
        
        // prodecode를 입력받아서 해당 제품의 Detail 정보를 가져온다.
        try {
            DetailsDAO detailsDAO = repository.findByProdCode(prodCode);
            System.out.println("              detailsDAO : " + detailsDAO.toString());
            response.setProdName(detailsDAO.getProdName());
            // Details File to String
            File file = new File(detailsDAO.getImgPath());
            String imgString = CommUtil.fileToString(file);
            response.setDetailsImg(imgString);
            response.setResultCode(200);
        }catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
        
        return response;
    }
}
