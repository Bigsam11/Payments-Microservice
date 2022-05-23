package com.paymentservice.controller;

import com.paymentservice.entity.ContentCreator;
import com.paymentservice.payloads.request.ContentCreatorRequest;
import com.paymentservice.payloads.response.CommonResponse;
import com.paymentservice.payloads.response.GenericServiceResponse;
import com.paymentservice.service.ContentCreatorService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/api")
public class ContentCreatorController {

    public final ContentCreatorService contentCreatorService;


    public ContentCreatorController(ContentCreatorService contentCreatorService){
        this.contentCreatorService = contentCreatorService ;
    }

      @PostMapping("/OnboardContentCreator")
      public ResponseEntity<Object> CreateContentCreator(@Valid @RequestBody ContentCreatorRequest contentCreator){
          GenericServiceResponse creator = contentCreatorService.createContentCreator(contentCreator);
          return  CommonResponse.generateResponse(creator.responseCode(),
                  creator.responseBody() == null ? false : true,
                  creator.responseMessage(),
                  creator.responseBody());
      }

      @GetMapping("/GetAllContentCreators")
      public ResponseEntity<Object> GetContentCreators(){
          GenericServiceResponse creators = contentCreatorService.fetchAllContentCreators();
          return  CommonResponse.generateResponse(creators.responseCode(),
                  creators.responseBody() == null ? false : true,
                  creators.responseMessage(),
                  creators.responseBody());
      }

      @GetMapping("/GetContentCreatorById/{creatorId}")
      public ResponseEntity<Object> GetContentCreatorById(@PathVariable("creatorId") Long creatorId){
          GenericServiceResponse creators = contentCreatorService.fetchAllContentCreatorById(creatorId);
          return  CommonResponse.generateResponse(creators.responseCode(),
                  creators.responseBody() == null ? false : true,
                  creators.responseMessage(),
                  creators.responseBody());
      }

    @PutMapping("/UpdateContentCreator{creatorId}")
    public ResponseEntity<Object> UpdateContentCreator(@PathVariable("creatorId") Long creatorId,@RequestBody ContentCreatorRequest contentCreatorRequest){
        GenericServiceResponse creators = contentCreatorService.updateContentCreator(creatorId,contentCreatorRequest);
        return  CommonResponse.generateResponse(creators.responseCode(),
                creators.responseBody() == null ? false : true,
                creators.responseMessage(),
                creators.responseBody());
    }

    @DeleteMapping("/DisableContentCreator{creatorId}")
    public ResponseEntity<Object> DisableContentCreator(@PathVariable("creatorId") Long creatorId){
        GenericServiceResponse creators = contentCreatorService.disableContentCreator(creatorId);
        return  CommonResponse.generateResponse(creators.responseCode(),
                creators.responseBody() == null ? false : true,
                creators.responseMessage(),
                creators.responseBody());
    }

}
