package com.honda.rest.builder.constants;

public class RestBuilderConstants {

	private RestBuilderConstants() {
		throw new IllegalStateException("Constants class");
	}

	public static final String AUTH_VERIFIER_GUEST_ALLOWED = "auth.verifier.guest.allowed";

	public static final String JAX_RS_APPLICATION_BASE_VAL = "/headless-delivery/v1.0";

	public static final String JAX_RS_NAME_VAL = "Honda.Rest";

	public enum RestBuilderConstant {

		AHMC_APP_CODE_PARAM_KEY("ahmcAppCode"),

		ASSET_TYPE_PARAM_KEY("assetType"),

		BULLETIN_NUMBER_PARAM_KEY("BulletinNumber"),

		CONTENT_TYPE_PARAM_KEY("contentType"),

		CONTENT_DESCRIPTION_PARAM_KEY("Description"),

		CONTENT_DATE_PARAM_KEY("date"),

		DEPARTMENT_PARAM_KEY("department"),

		DESCRIPTION_PARAM_KEY("description"),

		DIVISION_PARAM_KEY("division"),

		ERROR_MSG_PARAM_KEY("No Such Asset types Available"),

		FILE_PARAM_KEY("file"),

		ISSUE_DATE_PARAM_KEY("IssueDate"),

		METADATA_PARAM_KEY("metadata"),

		MODEL_PARAM_KEY("Model"),

		PUB_ID_PARAM_KEY("PubId"),

		PART_NUMBER_PARAM_KEY("PartNumber"),

		TITLE_PARAM_KEY("title"),

		YEAR_PARAM_KEY("Year"),
		
		FIRSTNAME_PARAM_KEY("firstname"),
		
		LASTNAME_PARAM_KEY("lastname"),
		
		EMAIL_PARAM_KEY("emailAddress"),
		
		OPERATION_PARAM_KEY("operation");;

		RestBuilderConstant(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		private String value;

	}

}
