package cn.jitmarketing.web;

public class JsonResponseResult {

	/** 操作成功 */
	private static final Integer JSON_RESULT_SUCCESS = 0;
	/** 操作失败 */
	private static final Integer JSON_RESULT_FAILED = 1;

	/** 状态 0表成功 1表失败 */
	private Integer code;

	/** 业务需要返回的数据 */
	private Object data;

	/** 返回条数 */
	private Object number;

	/** 错误信息描述 */
	private String backMsg;

	protected JsonResponseResult(Integer code) {
		this.code = code;
	}

	protected JsonResponseResult(Integer code, String msg) {
		this.code = code;
		this.backMsg = msg;
	}

	/**
	 * 创建成功的JsonResult对象。
	 * 
	 * @return
	 */
	public static JsonResponseResult createSuccess() {
		final JsonResponseResult jsonResult = new JsonResponseResult(JsonResponseResult.JSON_RESULT_SUCCESS);
		return jsonResult;
	}

	/**
	 * 创建失败的JsonResult对象。
	 * 
	 * @return
	 */
	public static JsonResponseResult createFalied() {
		final JsonResponseResult jsonResult = new JsonResponseResult(JsonResponseResult.JSON_RESULT_FAILED);
		return jsonResult;
	}

	/**
	 * 创建失败的附错误信息的JsonResult对象。
	 * 
	 * @return
	 */
	public static JsonResponseResult createFalied(final String msg) {
		final JsonResponseResult jsonResult = new JsonResponseResult(JsonResponseResult.JSON_RESULT_FAILED, msg);
		return jsonResult;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getBackMsg() {
		return backMsg;
	}

	public void setBackMsg(String backMsg) {
		this.backMsg = backMsg;
	}

	public Object getNumber() {
		return number;
	}

	public void setNumber(Object number) {
		this.number = number;
	}

}