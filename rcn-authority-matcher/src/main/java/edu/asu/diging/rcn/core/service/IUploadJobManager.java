package edu.asu.diging.rcn.core.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import edu.asu.diging.rcn.core.model.IUploadJob;
import edu.asu.diging.simpleusers.core.model.IUser;

public interface IUploadJobManager {

    IUploadJob findUploadJob(String id);

    List<IUploadJob> createUploadJob(IUser user, MultipartFile file, byte[] fileBytes);

    byte[] getUploadedFile(IUploadJob job);

    List<IUploadJob> getUploadJobs(IUser user, int page);

    IUploadJob findUploadJobFullyLoaded(String id);

}