package com.baibao.core.file.fastDfs.client;

public class FileNotExistException extends FSException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7764468143431510209L;

	public FileNotExistException(String path) {
		super(FSErrorCode.FILE_NOT_EXIST, new Object[]{path});
	}

}
