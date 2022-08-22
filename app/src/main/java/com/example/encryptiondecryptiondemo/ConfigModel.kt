package com.example.encryptiondecryptiondemo

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class DeviceConfig(
    @SerializedName("face") val faceConfig: FaceConfig = FaceConfig(),
    @SerializedName("rfid") val rfIdConfig: RfIdConfig = RfIdConfig(),
    @SerializedName("passcode") val passcodeConfig: PasscodeConfig = PasscodeConfig(),
    @SerializedName("ble") val bleConfig: BleConfig = BleConfig(),
    @SerializedName("qr") val qrConfig: QrConfig = QrConfig(),
    @SerializedName("registration") val registrationConfig: RegistrationConfig = RegistrationConfig(),
    @SerializedName("call_resident") val callResidentConfig: CallResidentConfig = CallResidentConfig(),
    @SerializedName("call_for_help") val callForHelp: CallForHelpConfig = CallForHelpConfig(),
    @SerializedName("lift") val liftConfig: LiftConfig = LiftConfig(),
    @SerializedName("timers") val timer: Timers = Timers(),
    @SerializedName("facility") val facilityConfig: FacilityConfig = FacilityConfig(),
    @SerializedName("led") val led: LedConfig = LedConfig(),
    @SerializedName("device_meta") val deviceMeta: DeviceMeta = DeviceMeta(),
)


@Keep
data class FaceConfig(
    @SerializedName("enabled") val enabled: Boolean = true,
    @SerializedName("recognition_threshold") val recogThreshold: Float = 0.90f,
    @SerializedName("registration_threshold") val regisThreshold: Float = 0.90f, // unused
    @SerializedName("led_on_registration") val ledOnRegistration: Boolean = true // unused
)

@Keep
data class RfIdConfig(
    @SerializedName("enabled") val enabled: Boolean = true,
    @SerializedName("max_id_length") val maxLength: Int = 10 // unused
)

@Keep
data class PasscodeConfig(
    @SerializedName("enabled") val enabled: Boolean = true,
)

@Keep
data class BleConfig(
    @SerializedName("enabled") val enabled: Boolean = true,
)

@Keep
data class QrConfig(
    @SerializedName("enabled") val enabled: Boolean = true,
    @SerializedName("resident_qr") val residentQr: Boolean = true,
    @SerializedName("visitor_qr") val visitorQr: Boolean = true,
    @SerializedName("invite_qr") val inviteQr: Boolean = true,
)

@Keep
data class RegistrationConfig(
    @SerializedName("enabled") val enabled: Boolean = true,
    @SerializedName("face_registration") val faceRegistration: Boolean = true,
    @SerializedName("rfid_registration") val rfidRegistration: Boolean = true,
    @SerializedName("can_add_resident") val canAddResident: Boolean = true,
)

@Keep
data class CallResidentConfig(
    @SerializedName("enabled") val enabled: Boolean = true,
    @SerializedName("video_call") val videoCall: Boolean = true,
)

@Keep
data class CallForHelpConfig(
    @SerializedName("enabled") val enabled: Boolean = false,
    @SerializedName("max_call_duration") val maxCallDuration: Long = 3 * 60 * 1000L,
    @SerializedName("max_wait_time") val maxWaitTime: Long = 40 * 1000L
)

@Keep
data class LiftConfig(
    @SerializedName("enabled") val enabled: Boolean = false,
    @SerializedName("min_floor") val minFloor: Int = 0,
    @SerializedName("max_floor") val maxFloor: Int = 0,
    @SerializedName("common_floor") val commonFloor: String = "",
    @SerializedName("allow_others") val allowOthers: Boolean = false,
    @SerializedName("mqtt_topic") val mqttTopic: String = "nuc1/lift1",
    @SerializedName("private_lift") val privateLift: List<String> = emptyList(),
    @SerializedName("allow_cf_visitor") val allowCfVisitor : Boolean = true,
    @SerializedName("allow_cf_invite") val allowCfInvite : Boolean = true,
)

@Keep
data class Timers(
    @SerializedName("idle_timeout") val idleTimeout: Long = 60 * 1000,
    @SerializedName("restart") val appRestart: Long = 15 * 60 * 1000, // unused
    @SerializedName("led_timeout") val ledTimeout: Long = 5 * 1000,
    @SerializedName("relay_timeout") val relayTimeout: Long = 5 * 1000,
    @SerializedName("otp_retry_timeout") val otpRetryTimeout: Long = 30 * 1000,
)

@Keep
data class FacilityConfig(
    @SerializedName("enabled") val enabled: Boolean = false,
    @SerializedName("bookable") val bookable: Boolean = false,
    @SerializedName("check_permanent_block") val checkPermanentBlock: Boolean = false,

    @SerializedName("time_restricted") val timeRestricted: Boolean = false,
    @SerializedName("facility_start_time") val facilityStartTime: Int = 0,
    @SerializedName("facility_end_time") val facilityEndTime: Int = 24,
)


//Change requested by duvarakesh
@Keep
enum class LedMode {
    NIGHT_ONLY,
    OFF,
    ON,
    ON_MOVEMENT
}

@Keep
data class LedConfig(
    val mode: LedMode = LedMode.OFF,
    @SerializedName("on_time") val onTime: Int = 18,
    @SerializedName("off_time") val offTime: Int = 6,
)


@Keep
data class DeviceMeta(
    @SerializedName("relay") val relay: Boolean = true,
    @SerializedName("speech") val speech: Boolean = true,
    @SerializedName("device_type") val type: String = "LOBBY",
    @SerializedName("password") val password: String? = null,
    @SerializedName("pattern") val pattern: String? = null,
    @SerializedName("reset_pattern") val resetPattern: String? = null,
    @SerializedName("video_call") val videoCall: Boolean = true,
    @SerializedName("participant_view") val participantView: Boolean = true,
    @SerializedName("allow_others_in_pb") val allowOthersInPb: Boolean = true,
    @SerializedName("permanent_blocks") val permanentBlocks: List<String> = emptyList(),
    @SerializedName("welcome_template") val welcomeTemplate: String = "Welcome !",
    @SerializedName("volume") val volume: Int = 66
)

@Keep
data class Mqtt(
    val host: String,
    val port: String,
    val password: String,
    val username: String
)
