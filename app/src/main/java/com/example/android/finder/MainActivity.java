package com.example.android.finder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText dateinput, pincodeInput;
    RadioButton pincodeButton, districtButton;
    Spinner stateInput, districtInput;
    Button checkBtn;
    RelativeLayout pincodeLayout, districtLayout;
    RadioGroup radioGroup;

    CardView resultsCard;

    ArrayList<objectData> resultList;

    RecyclerView resultView;
    resultListAdapter result_list_adapter;
    RecyclerView.LayoutManager result_list_layout_manager;

    String date=null;
    private RequestQueue mqueue;

    String month, day, year;
    String pincode;
    String districtid;

    ArrayList<dataFile> stateData;

    ArrayList<dataFile> AndamanandNicobarIslands;
    ArrayList<dataFile> AndhraPradesh;
    ArrayList<dataFile> ArunachalPradesh;
    ArrayList<dataFile> Assam;
    ArrayList<dataFile> Bihar;
    ArrayList<dataFile> Chandigarh;
    ArrayList<dataFile> Chhattisgarh;
    ArrayList<dataFile> DadraandNagarHaveli;
    ArrayList<dataFile> DamanandDiu;
    ArrayList<dataFile> Delhi;
    ArrayList<dataFile> Goa;
    ArrayList<dataFile> Gujarat;
    ArrayList<dataFile> Haryana;
    ArrayList<dataFile> HimachalPradesh;
    ArrayList<dataFile> JammuandKashmir;
    ArrayList<dataFile> Jharkhand;
    ArrayList<dataFile> Karnataka;
    ArrayList<dataFile> Kerala;
    ArrayList<dataFile> Ladakh;
    ArrayList<dataFile> Lakshadweep;
    ArrayList<dataFile> MadhyaPradesh;
    ArrayList<dataFile> Maharashtra;
    ArrayList<dataFile> Manipur;
    ArrayList<dataFile> Meghalaya;
    ArrayList<dataFile> Mizoram;
    ArrayList<dataFile> Nagaland;
    ArrayList<dataFile> Odisha;
    ArrayList<dataFile> Puducherry;
    ArrayList<dataFile> Punjab;
    ArrayList<dataFile> Rajasthan;
    ArrayList<dataFile> Sikkim;
    ArrayList<dataFile> TamilNadu;
    ArrayList<dataFile> Telangana;
    ArrayList<dataFile> Tripura;
    ArrayList<dataFile> UttarPradesh;
    ArrayList<dataFile> Uttarakhand;
    ArrayList<dataFile> WestBengal;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stateData=new ArrayList<>();

        stateData.add(new dataFile(1,"Andaman and Nicobar Islands"));
        stateData.add(new dataFile(2,"Andhra Pradesh"));
        stateData.add(new dataFile(3,"Arunachal Pradesh"));
        stateData.add(new dataFile(4,"Assam"));
        stateData.add(new dataFile(5,"Bihar"));
        stateData.add(new dataFile(6,"Chandigarh"));
        stateData.add(new dataFile(7,"Chhattisgarh"));
        stateData.add(new dataFile(8,"Dadra and Nagar Haveli"));
        stateData.add(new dataFile(37,"Daman and Diu"));
        stateData.add(new dataFile(9,"Delhi"));
        stateData.add(new dataFile(10,"Goa"));
        stateData.add(new dataFile(11,"Gujarat"));
        stateData.add(new dataFile(12,"Haryana"));
        stateData.add(new dataFile(13,"Himachal Pradesh"));
        stateData.add(new dataFile(14,"Jammu and Kashmir"));
        stateData.add(new dataFile(15,"Jharkhand"));
        stateData.add(new dataFile(16,"Karnataka"));
        stateData.add(new dataFile(17,"Kerala"));
        stateData.add(new dataFile(18,"Ladakh"));
        stateData.add(new dataFile(19,"Lakshadweep"));
        stateData.add(new dataFile(20,"Madhya Pradesh"));
        stateData.add(new dataFile(21,"Maharashtra"));
        stateData.add(new dataFile(22,"Manipur"));
        stateData.add(new dataFile(23,"Meghalaya"));
        stateData.add(new dataFile(24,"Mizoram"));
        stateData.add(new dataFile(25,"Nagaland"));
        stateData.add(new dataFile(26,"Odisha"));
        stateData.add(new dataFile(27,"Puducherry"));
        stateData.add(new dataFile(28,"Punjab"));
        stateData.add(new dataFile(29, "Rajasthan"));
        stateData.add(new dataFile(30,"Sikkim"));
        stateData.add(new dataFile(31,"Tamil Nadu"));
        stateData.add(new dataFile(32, "Telangana"));
        stateData.add(new dataFile(33,"Tripura"));
        stateData.add(new dataFile(34,"Uttar Pradesh"));
        stateData.add(new dataFile(35,"Uttarakhand"));
        stateData.add(new dataFile(36,"West Bengal"));

        AndamanandNicobarIslands=new ArrayList<>();

        AndamanandNicobarIslands.add(new dataFile(3,"Nicobar"));
        AndamanandNicobarIslands.add(new dataFile(1,"North and Middle Andaman"));
        AndamanandNicobarIslands.add(new dataFile(2,"South Andaman"));

        AndhraPradesh=new ArrayList<>();

        AndhraPradesh.add(new dataFile(9,"Anantapur"));
        AndhraPradesh.add(new dataFile(10,"Chittoor"));
        AndhraPradesh.add(new dataFile(11,"East Godavari"));
        AndhraPradesh.add(new dataFile(5,"Guntur"));
        AndhraPradesh.add(new dataFile(4,"Krishna"));
        AndhraPradesh.add(new dataFile(7,"Kurnool"));
        AndhraPradesh.add(new dataFile(12,"Prakasam"));
        AndhraPradesh.add(new dataFile(13,"Sri Potti Sriramulu Nellore"));
        AndhraPradesh.add(new dataFile(14,"Srikakulam"));
        AndhraPradesh.add(new dataFile(8,"Visakhapatnam"));
        AndhraPradesh.add(new dataFile(15,"Vizianagaram"));
        AndhraPradesh.add(new dataFile(16,"West Godavari"));
        AndhraPradesh.add(new dataFile(6,"YSR District, Kadapa (Cuddapah)"));

        ArunachalPradesh=new ArrayList<>();

        ArunachalPradesh.add(new dataFile(22,"Anjaw"));
        ArunachalPradesh.add(new dataFile(20,"Changlang"));
        ArunachalPradesh.add(new dataFile(25,"Dibang Valley"));
        ArunachalPradesh.add(new dataFile(23,"East Kameng"));
        ArunachalPradesh.add(new dataFile(42,"East Siang"));
        ArunachalPradesh.add(new dataFile(17,"Itanagar Capital Complex"));
        ArunachalPradesh.add(new dataFile(24,"Kamle"));
        ArunachalPradesh.add(new dataFile(27,"Kra Daadi"));
        ArunachalPradesh.add(new dataFile(21,"Kurung Kumey"));
        ArunachalPradesh.add(new dataFile(33,"Lepa Rada"));
        ArunachalPradesh.add(new dataFile(29,"Lohit"));
        ArunachalPradesh.add(new dataFile(40,"Longding"));
        ArunachalPradesh.add(new dataFile(31,"Lower Dibang Valley"));
        ArunachalPradesh.add(new dataFile(18,"Lower Siang"));
        ArunachalPradesh.add(new dataFile(32,"Lower Subansiri"));
        ArunachalPradesh.add(new dataFile(36,"Namsai"));
        ArunachalPradesh.add(new dataFile(19,"Pakke Kessang"));
        ArunachalPradesh.add(new dataFile(39,"Papum Pare"));
        ArunachalPradesh.add(new dataFile(35,"Shi Yomi"));
        ArunachalPradesh.add(new dataFile(37,"Siang"));
        ArunachalPradesh.add(new dataFile(30,"Tawang"));
        ArunachalPradesh.add(new dataFile(26,"Tirap"));
        ArunachalPradesh.add(new dataFile(34,"Upper Siang"));
        ArunachalPradesh.add(new dataFile(41,"Upper Subansiri"));
        ArunachalPradesh.add(new dataFile(28,"West Kameng"));
        ArunachalPradesh.add(new dataFile(38,"West Siang"));

        Assam=new ArrayList<>();

        Assam.add(new dataFile(46,"Baksa"));
        Assam.add(new dataFile(47,"Barpeta"));
        Assam.add(new dataFile(765,"Biswanath"));
        Assam.add(new dataFile(57,"Bongaigaon"));
        Assam.add(new dataFile(66,"Cachar"));
        Assam.add(new dataFile(766,"Charaideo"));
        Assam.add(new dataFile(58,"Chirang"));
        Assam.add(new dataFile(48,"Darrang"));
        Assam.add(new dataFile(62,"Dhemaji"));
        Assam.add(new dataFile(59,"Dhubri"));
        Assam.add(new dataFile(43,"Dibrugarh"));
        Assam.add(new dataFile(67,"Dima Hasao"));
        Assam.add(new dataFile(60,"Goalpara"));
        Assam.add(new dataFile(53,"Golaghat"));
        Assam.add(new dataFile(68,"Hailakandi"));
        Assam.add(new dataFile(764,"Hojai"));
        Assam.add(new dataFile(54,"Jorhat"));
        Assam.add(new dataFile(49,"Kamrup Metropolitan"));
        Assam.add(new dataFile(50,"Kamrup Rural"));
        Assam.add(new dataFile(51,"Karbi-Anglong"));
        Assam.add(new dataFile(69,"Karimganj"));
        Assam.add(new dataFile(61,"Kokrajhar"));
        Assam.add(new dataFile(63,"Lakhimpur"));
        Assam.add(new dataFile(767,"Majuli"));
        Assam.add(new dataFile(55,"Morigaon"));
        Assam.add(new dataFile(56,"Nagaon"));
        Assam.add(new dataFile(52,"Nalbari"));
        Assam.add(new dataFile(44,"Sivasagar"));
        Assam.add(new dataFile(64,"Sonitpur"));
        Assam.add(new dataFile(768,"South Salmara Mankachar"));
        Assam.add(new dataFile(45,"Tinsukia"));
        Assam.add(new dataFile(65,"Udalguri"));
        Assam.add(new dataFile(769,"West Karbi Anglong"));


        Bihar=new ArrayList<>();

        Bihar.add(new dataFile(74,"Araria"));
        Bihar.add(new dataFile(78,"Arwal"));
        Bihar.add(new dataFile(77,"Aurangabad"));
        Bihar.add(new dataFile(83,"Banka"));
        Bihar.add(new dataFile(98,"Begusarai"));
        Bihar.add(new dataFile(82,"Bhagalpur"));
        Bihar.add(new dataFile(99,"Bhojpur"));
        Bihar.add(new dataFile(100,"Buxar"));
        Bihar.add(new dataFile(94,"Darbhanga"));
        Bihar.add(new dataFile(105,"East Champaran"));
        Bihar.add(new dataFile(79,"Gaya"));
        Bihar.add(new dataFile(104,"Gopalganj"));
        Bihar.add(new dataFile(107,"Jamui"));
        Bihar.add(new dataFile(91,"Jehanabad"));
        Bihar.add(new dataFile(80,"Kaimur"));
        Bihar.add(new dataFile(75,"Katihar"));
        Bihar.add(new dataFile(101,"Khagaria"));
        Bihar.add(new dataFile(76,"Kishanganj"));
        Bihar.add(new dataFile(84,"Lakhisarai"));
        Bihar.add(new dataFile(70,"Madhepura"));
        Bihar.add(new dataFile(95,"Madhubani"));
        Bihar.add(new dataFile(85,"Munger"));
        Bihar.add(new dataFile(86,"Muzaffarpur"));
        Bihar.add(new dataFile(90,"Nalanda"));
        Bihar.add(new dataFile(92,"Nawada"));
        Bihar.add(new dataFile(97,"Patna"));
        Bihar.add(new dataFile(73,"Purnia"));
        Bihar.add(new dataFile(81,"Rohtas"));
        Bihar.add(new dataFile(71,"Saharsa"));
        Bihar.add(new dataFile(96,"Samastipur"));
        Bihar.add(new dataFile(102,"Saran"));
        Bihar.add(new dataFile(93,"Sheikhpura"));
        Bihar.add(new dataFile(87,"Sheohar"));
        Bihar.add(new dataFile(88,"Sitamarhi"));
        Bihar.add(new dataFile(103,"Siwan"));
        Bihar.add(new dataFile(72,"Supaul"));
        Bihar.add(new dataFile(89,"Vaishali"));
        Bihar.add(new dataFile(106,"West Champaran"));


        Chandigarh=new ArrayList<>();
        Chandigarh.add(new dataFile(108,"Chandigarh"));

        Chhattisgarh=new ArrayList<>();

        Chhattisgarh.add(new dataFile(110,"Balod"));
        Chhattisgarh.add(new dataFile(111,"Baloda bazar"));
        Chhattisgarh.add(new dataFile(112,"Balrampur"));
        Chhattisgarh.add(new dataFile(113,"Bastar"));
        Chhattisgarh.add(new dataFile(114,"Bemetara"));
        Chhattisgarh.add(new dataFile(115,"Bijapur"));
        Chhattisgarh.add(new dataFile(116,"Bilaspur"));
        Chhattisgarh.add(new dataFile(117,"Dantewada"));
        Chhattisgarh.add(new dataFile(118,"Dhamtari"));
        Chhattisgarh.add(new dataFile(119,"Durg"));
        Chhattisgarh.add(new dataFile(120,"Gariaband"));
        Chhattisgarh.add(new dataFile(136,"Gaurela Pendra Marwahi "));
        Chhattisgarh.add(new dataFile(121,"Janjgir-Champa"));
        Chhattisgarh.add(new dataFile(122,"Jashpur"));
        Chhattisgarh.add(new dataFile(123,"Kanker"));
        Chhattisgarh.add(new dataFile(135,"Kawardha"));
        Chhattisgarh.add(new dataFile(124,"Kondagaon"));
        Chhattisgarh.add(new dataFile(125,"Korba"));
        Chhattisgarh.add(new dataFile(126,"Koriya"));
        Chhattisgarh.add(new dataFile(127,"Mahasamund"));
        Chhattisgarh.add(new dataFile(128,"Mungeli"));
        Chhattisgarh.add(new dataFile(129,"Narayanpur"));
        Chhattisgarh.add(new dataFile(130,"Raigarh"));
        Chhattisgarh.add(new dataFile(109,"Raipur"));
        Chhattisgarh.add(new dataFile(131,"Rajnandgaon"));
        Chhattisgarh.add(new dataFile(132,"Sukma"));
        Chhattisgarh.add(new dataFile(133,"Surajpur"));
        Chhattisgarh.add(new dataFile(134,"Surguja"));

        DadraandNagarHaveli=new ArrayList<>();
        DadraandNagarHaveli.add(new dataFile(137,"Dadra and Nagar Haveli"));


        DamanandDiu=new ArrayList<>();

        DamanandDiu.add(new dataFile(138,"Daman"));
        DamanandDiu.add(new dataFile(139,"Diu"));


        Delhi=new ArrayList<>();

        Delhi.add(new dataFile(141,"Central Delhi"));
        Delhi.add(new dataFile(145,"East Delhi"));
        Delhi.add(new dataFile(140,"New Delhi"));
        Delhi.add(new dataFile(146,"North Delhi"));
        Delhi.add(new dataFile(147,"North East Delhi"));
        Delhi.add(new dataFile(143,"North West Delhi"));
        Delhi.add(new dataFile(148,"Shahdara"));
        Delhi.add(new dataFile(149,"South Delhi"));
        Delhi.add(new dataFile(144,"South East Delhi"));
        Delhi.add(new dataFile(150,"South West Delhi"));
        Delhi.add(new dataFile(142,"West Delhi"));

        Goa=new ArrayList<>();

        Goa.add(new dataFile(151,"North Goa"));
        Goa.add(new dataFile(152,"South Goa"));

        Gujarat=new ArrayList<>();

        Gujarat.add(new dataFile(154,"Ahmedabad"));
        Gujarat.add(new dataFile(770,"Ahmedabad Corporation"));
        Gujarat.add(new dataFile(174,"Amreli"));
        Gujarat.add(new dataFile(179,"Anand"));
        Gujarat.add(new dataFile(158,"Aravalli"));
        Gujarat.add(new dataFile(159,"Banaskantha"));
        Gujarat.add(new dataFile(180,"Bharuch"));
        Gujarat.add(new dataFile(175,"Bhavnagar"));
        Gujarat.add(new dataFile(771,"Bhavnagar Corporation"));
        Gujarat.add(new dataFile(176,"Botad"));
        Gujarat.add(new dataFile(181,"Chhotaudepur"));
        Gujarat.add(new dataFile(182,"Dahod"));
        Gujarat.add(new dataFile(163,"Dang"));
        Gujarat.add(new dataFile(168,"Devbhumi Dwaraka"));
        Gujarat.add(new dataFile(153,"Gandhinagar"));
        Gujarat.add(new dataFile(772,"Gandhinagar Corporation"));
        Gujarat.add(new dataFile(177,"Gir Somnath"));
        Gujarat.add(new dataFile(169,"Jamnagar"));
        Gujarat.add(new dataFile(773,"Jamnagar Corporation"));
        Gujarat.add(new dataFile(178,"Junagadh"));
        Gujarat.add(new dataFile(774,"Junagadh Corporation"));
        Gujarat.add(new dataFile(156,"Kheda"));
        Gujarat.add(new dataFile(170,"Kutch"));
        Gujarat.add(new dataFile(183,"Mahisagar"));
        Gujarat.add(new dataFile(160,"Mehsana"));
        Gujarat.add(new dataFile(171,"Morbi"));
        Gujarat.add(new dataFile(184,"Narmada"));
        Gujarat.add(new dataFile(164,"Navsari"));
        Gujarat.add(new dataFile(185,"Panchmahal"));
        Gujarat.add(new dataFile(161,"Patan"));
        Gujarat.add(new dataFile(172,"Porbandar"));
        Gujarat.add(new dataFile(173,"Rajkot"));
        Gujarat.add(new dataFile(775,"Rajkot Corporation"));
        Gujarat.add(new dataFile(162,"Sabarkantha"));
        Gujarat.add(new dataFile(165,"Surat"));
        Gujarat.add(new dataFile(776,"Surat Corporation"));
        Gujarat.add(new dataFile(157,"Surendranagar"));
        Gujarat.add(new dataFile(166,"Tapi"));
        Gujarat.add(new dataFile(155,"Vadodara"));
        Gujarat.add(new dataFile(777,"Vadodara Corporation"));
        Gujarat.add(new dataFile(167,"Valsad"));

        Haryana=new ArrayList<>();

        Haryana.add(new dataFile(193,"Ambala"));
        Haryana.add(new dataFile(200,"Bhiwani"));
        Haryana.add(new dataFile(201,"Charkhi Dadri"));
        Haryana.add(new dataFile(199,"Faridabad"));
        Haryana.add(new dataFile(196,"Fatehabad"));
        Haryana.add(new dataFile(188,"Gurgaon"));
        Haryana.add(new dataFile(191,"Hisar"));
        Haryana.add(new dataFile(189,"Jhajjar"));
        Haryana.add(new dataFile(204,"Jind"));
        Haryana.add(new dataFile(190,"Kaithal"));
        Haryana.add(new dataFile(203,"Karnal"));
        Haryana.add(new dataFile(186,"Kurukshetra"));
        Haryana.add(new dataFile(206,"Mahendragarh"));
        Haryana.add(new dataFile(205,"Nuh"));
        Haryana.add(new dataFile(207,"Palwal"));
        Haryana.add(new dataFile(187,"Panchkula"));
        Haryana.add(new dataFile(195,"Panipat"));
        Haryana.add(new dataFile(202,"Rewari"));
        Haryana.add(new dataFile(192,"Rohtak"));
        Haryana.add(new dataFile(194,"Sirsa"));
        Haryana.add(new dataFile(198,"Sonipat"));
        Haryana.add(new dataFile(197,"Yamunanagar"));

        HimachalPradesh=new ArrayList<>();

        HimachalPradesh.add(new dataFile(219,"Bilaspur"));
        HimachalPradesh.add(new dataFile(214,"Chamba"));
        HimachalPradesh.add(new dataFile(217,"Hamirpur"));
        HimachalPradesh.add(new dataFile(213,"Kangra"));
        HimachalPradesh.add(new dataFile(216,"Kinnaur"));
        HimachalPradesh.add(new dataFile(211,"Kullu"));
        HimachalPradesh.add(new dataFile(210,"Lahaul Spiti"));
        HimachalPradesh.add(new dataFile(215,"Mandi"));
        HimachalPradesh.add(new dataFile(208,"Shimla"));
        HimachalPradesh.add(new dataFile(212,"Sirmaur"));
        HimachalPradesh.add(new dataFile(209,"Solan"));
        HimachalPradesh.add(new dataFile(218,"Una"));

        JammuandKashmir=new ArrayList<>();

        JammuandKashmir.add(new dataFile(224,"Anantnag"));
        JammuandKashmir.add(new dataFile(223,"Bandipore"));
        JammuandKashmir.add(new dataFile(225,"Baramulla"));
        JammuandKashmir.add(new dataFile(229,"Budgam"));
        JammuandKashmir.add(new dataFile(232,"Doda"));
        JammuandKashmir.add(new dataFile(228,"Ganderbal"));
        JammuandKashmir.add(new dataFile(230,"Jammu"));
        JammuandKashmir.add(new dataFile(234,"Kathua"));
        JammuandKashmir.add(new dataFile(231,"Kishtwar"));
        JammuandKashmir.add(new dataFile(221,"Kulgam"));
        JammuandKashmir.add(new dataFile(226,"Kupwara"));
        JammuandKashmir.add(new dataFile(238,"Poonch"));
        JammuandKashmir.add(new dataFile(227,"Pulwama"));
        JammuandKashmir.add(new dataFile(237,"Rajouri"));
        JammuandKashmir.add(new dataFile(235,"Ramban"));
        JammuandKashmir.add(new dataFile(239,"Reasi"));
        JammuandKashmir.add(new dataFile(236,"Samba"));
        JammuandKashmir.add(new dataFile(222,"Shopian"));
        JammuandKashmir.add(new dataFile(220,"Srinagar"));
        JammuandKashmir.add(new dataFile(233,"Udhampur"));

        Jharkhand=new ArrayList<>();

        Jharkhand.add(new dataFile(242,"Bokaro"));
        Jharkhand.add(new dataFile(245,"Chatra"));
        Jharkhand.add(new dataFile(253,"Deoghar"));
        Jharkhand.add(new dataFile(257,"Dhanbad"));
        Jharkhand.add(new dataFile(258,"Dumka"));
        Jharkhand.add(new dataFile(247,"East Singhbhum"));
        Jharkhand.add(new dataFile(243,"Garhwa"));
        Jharkhand.add(new dataFile(256,"Giridih"));
        Jharkhand.add(new dataFile(262,"Godda"));
        Jharkhand.add(new dataFile(251,"Gumla"));
        Jharkhand.add(new dataFile(255,"Hazaribagh"));
        Jharkhand.add(new dataFile(259,"Jamtara"));
        Jharkhand.add(new dataFile(252,"Khunti"));
        Jharkhand.add(new dataFile(241,"Koderma"));
        Jharkhand.add(new dataFile(244,"Latehar"));
        Jharkhand.add(new dataFile(250,"Lohardaga"));
        Jharkhand.add(new dataFile(261,"Pakur"));
        Jharkhand.add(new dataFile(246,"Palamu"));
        Jharkhand.add(new dataFile(254,"Ramgarh"));
        Jharkhand.add(new dataFile(240,"Ranchi"));
        Jharkhand.add(new dataFile(260,"Sahebganj"));
        Jharkhand.add(new dataFile(248,"Seraikela Kharsawan"));
        Jharkhand.add(new dataFile(249,"Simdega"));
        Jharkhand.add(new dataFile(263,"West Singhbhum"));

        Karnataka=new ArrayList<>();

        Karnataka.add(new dataFile(270,"Bagalkot"));
        Karnataka.add(new dataFile(276,"Bangalore Rural"));
        Karnataka.add(new dataFile(265,"Bangalore Urban"));
        Karnataka.add(new dataFile(294,"BBMP"));
        Karnataka.add(new dataFile(264,"Belgaum"));
        Karnataka.add(new dataFile(274,"Bellary"));
        Karnataka.add(new dataFile(272,"Bidar"));
        Karnataka.add(new dataFile(271,"Chamarajanagar"));
        Karnataka.add(new dataFile(273,"Chikamagalur"));
        Karnataka.add(new dataFile(291,"Chikkaballapur"));
        Karnataka.add(new dataFile(268,"Chitradurga"));
        Karnataka.add(new dataFile(269,"Dakshina Kannada"));
        Karnataka.add(new dataFile(275,"Davanagere"));
        Karnataka.add(new dataFile(278,"Dharwad"));
        Karnataka.add(new dataFile(280,"Gadag"));
        Karnataka.add(new dataFile(267,"Gulbarga"));
        Karnataka.add(new dataFile(289,"Hassan"));
        Karnataka.add(new dataFile(279,"Haveri"));
        Karnataka.add(new dataFile(283,"Kodagu"));
        Karnataka.add(new dataFile(277,"Kolar"));
        Karnataka.add(new dataFile(282,"Koppal"));
        Karnataka.add(new dataFile(290,"Mandya"));
        Karnataka.add(new dataFile(266,"Mysore"));
        Karnataka.add(new dataFile(284,"Raichur"));
        Karnataka.add(new dataFile(292,"Ramanagara"));
        Karnataka.add(new dataFile(287,"Shimoga"));
        Karnataka.add(new dataFile(288,"Tumkur"));
        Karnataka.add(new dataFile(286,"Udupi"));
        Karnataka.add(new dataFile(281,"Uttar Kannada"));
        Karnataka.add(new dataFile(293,"Vijayapura"));
        Karnataka.add(new dataFile(285,"Yadgir"));

        Kerala=new ArrayList<>();

        Kerala.add(new dataFile(301,"Alappuzha"));
        Kerala.add(new dataFile(307,"Ernakulam"));
        Kerala.add(new dataFile(306,"Idukki"));
        Kerala.add(new dataFile(297,"Kannur"));
        Kerala.add(new dataFile(295,"Kasaragod"));
        Kerala.add(new dataFile(298,"Kollam"));
        Kerala.add(new dataFile(304,"Kottayam"));
        Kerala.add(new dataFile(305,"Kozhikode"));
        Kerala.add(new dataFile(302,"Malappuram"));
        Kerala.add(new dataFile(308,"Palakkad"));
        Kerala.add(new dataFile(300,"Pathanamthitta"));
        Kerala.add(new dataFile(296,"Thiruvananthapuram"));
        Kerala.add(new dataFile(303,"Thrissur"));
        Kerala.add(new dataFile(299,"Wayanad"));

        Ladakh=new ArrayList<>();

        Ladakh.add(new dataFile(309,"Kargil"));
        Ladakh.add(new dataFile(310,"Leh"));

        Lakshadweep=new ArrayList<>();

        Lakshadweep.add(new dataFile(796,"Agatti Island"));
        Lakshadweep.add(new dataFile(311,"Lakshadweep"));

        MadhyaPradesh=new ArrayList<>();

        MadhyaPradesh.add(new dataFile(320,"Agar"));
        MadhyaPradesh.add(new dataFile(357,"Alirajpur"));
        MadhyaPradesh.add(new dataFile(334,"Anuppur"));
        MadhyaPradesh.add(new dataFile(354,"Ashoknagar"));
        MadhyaPradesh.add(new dataFile(338,"Balaghat"));
        MadhyaPradesh.add(new dataFile(343,"Barwani"));
        MadhyaPradesh.add(new dataFile(362,"Betul"));
        MadhyaPradesh.add(new dataFile(351,"Bhind"));
        MadhyaPradesh.add(new dataFile(312,"Bhopal"));
        MadhyaPradesh.add(new dataFile(342,"Burhanpur"));
        MadhyaPradesh.add(new dataFile(328,"Chhatarpur"));
        MadhyaPradesh.add(new dataFile(337,"Chhindwara"));
        MadhyaPradesh.add(new dataFile(327,"Damoh"));
        MadhyaPradesh.add(new dataFile(350,"Datia"));
        MadhyaPradesh.add(new dataFile(324,"Dewas"));
        MadhyaPradesh.add(new dataFile(341,"Dhar"));
        MadhyaPradesh.add(new dataFile(336,"Dindori"));
        MadhyaPradesh.add(new dataFile(348,"Guna"));
        MadhyaPradesh.add(new dataFile(313,"Gwalior"));
        MadhyaPradesh.add(new dataFile(361,"Harda"));
        MadhyaPradesh.add(new dataFile(360,"Hoshangabad"));
        MadhyaPradesh.add(new dataFile(314,"Indore"));
        MadhyaPradesh.add(new dataFile(315,"Jabalpur"));
        MadhyaPradesh.add(new dataFile(340,"Jhabua"));
        MadhyaPradesh.add(new dataFile(353,"Katni"));
        MadhyaPradesh.add(new dataFile(339,"Khandwa"));
        MadhyaPradesh.add(new dataFile(344,"Khargone"));
        MadhyaPradesh.add(new dataFile(335,"Mandla"));
        MadhyaPradesh.add(new dataFile(319,"Mandsaur"));
        MadhyaPradesh.add(new dataFile(347,"Morena"));
        MadhyaPradesh.add(new dataFile(352,"Narsinghpur"));
        MadhyaPradesh.add(new dataFile(323,"Neemuch"));
        MadhyaPradesh.add(new dataFile(326,"Panna"));
        MadhyaPradesh.add(new dataFile(359,"Raisen"));
        MadhyaPradesh.add(new dataFile(358,"Rajgarh"));
        MadhyaPradesh.add(new dataFile(322,"Ratlam"));
        MadhyaPradesh.add(new dataFile(316,"Rewa"));
        MadhyaPradesh.add(new dataFile(317,"Sagar"));
        MadhyaPradesh.add(new dataFile(333,"Satna"));
        MadhyaPradesh.add(new dataFile(356,"Sehore"));
        MadhyaPradesh.add(new dataFile(349,"Seoni"));
        MadhyaPradesh.add(new dataFile(332,"Shahdol"));
        MadhyaPradesh.add(new dataFile(321,"Shajapur"));
        MadhyaPradesh.add(new dataFile(346,"Sheopur"));
        MadhyaPradesh.add(new dataFile(345,"Shivpuri"));
        MadhyaPradesh.add(new dataFile(331,"Sidhi"));
        MadhyaPradesh.add(new dataFile(330,"Singrauli"));
        MadhyaPradesh.add(new dataFile(325,"Tikamgarh"));
        MadhyaPradesh.add(new dataFile(318,"Ujjain"));
        MadhyaPradesh.add(new dataFile(329,"Umaria"));
        MadhyaPradesh.add(new dataFile(355,"Vidisha"));

        Maharashtra=new ArrayList<>();

        Maharashtra.add(new dataFile(391,"Ahmednagar"));
        Maharashtra.add(new dataFile(364,"Akola"));
        Maharashtra.add(new dataFile(366,"Amravati"));
        Maharashtra.add(new dataFile(397,"Aurangabad "));
        Maharashtra.add(new dataFile(384,"Beed"));
        Maharashtra.add(new dataFile(370,"Bhandara"));
        Maharashtra.add(new dataFile(367,"Buldhana"));
        Maharashtra.add(new dataFile(380,"Chandrapur"));
        Maharashtra.add(new dataFile(388,"Dhule"));
        Maharashtra.add(new dataFile(379,"Gadchiroli"));
        Maharashtra.add(new dataFile(378,"Gondia"));
        Maharashtra.add(new dataFile(386,"Hingoli"));
        Maharashtra.add(new dataFile(390,"Jalgaon"));
        Maharashtra.add(new dataFile(396,"Jalna"));
        Maharashtra.add(new dataFile(371,"Kolhapur"));
        Maharashtra.add(new dataFile(383,"Latur"));
        Maharashtra.add(new dataFile(395,"Mumbai"));
        Maharashtra.add(new dataFile(365,"Nagpur"));
        Maharashtra.add(new dataFile(382,"Nanded"));
        Maharashtra.add(new dataFile(387,"Nandurbar"));
        Maharashtra.add(new dataFile(389,"Nashik"));
        Maharashtra.add(new dataFile(381,"Osmanabad"));
        Maharashtra.add(new dataFile(394,"Palghar"));
        Maharashtra.add(new dataFile(385,"Parbhani"));
        Maharashtra.add(new dataFile(363,"Pune"));
        Maharashtra.add(new dataFile(393,"Raigad"));
        Maharashtra.add(new dataFile(372,"Ratnagiri"));
        Maharashtra.add(new dataFile(373,"Sangli"));
        Maharashtra.add(new dataFile(376,"Satara"));
        Maharashtra.add(new dataFile(374,"Sindhudurg"));
        Maharashtra.add(new dataFile(375,"Solapur"));
        Maharashtra.add(new dataFile(392,"Thane"));
        Maharashtra.add(new dataFile(377,"Wardha"));
        Maharashtra.add(new dataFile(369,"Washim"));
        Maharashtra.add(new dataFile(368,"Yavatmal"));

        Manipur=new ArrayList<>();

        Manipur.add(new dataFile(398,"Bishnupur"));
        Manipur.add(new dataFile(399,"Chandel"));
        Manipur.add(new dataFile(400,"Churachandpur"));
        Manipur.add(new dataFile(401,"Imphal East"));
        Manipur.add(new dataFile(402,"Imphal West"));
        Manipur.add(new dataFile(410,"Jiribam"));
        Manipur.add(new dataFile(413,"Kakching"));
        Manipur.add(new dataFile(409,"Kamjong"));
        Manipur.add(new dataFile(408,"Kangpokpi"));
        Manipur.add(new dataFile(412,"Noney"));
        Manipur.add(new dataFile(411,"Pherzawl"));
        Manipur.add(new dataFile(403,"Senapati"));
        Manipur.add(new dataFile(404,"Tamenglong"));
        Manipur.add(new dataFile(407,"Tengnoupal"));
        Manipur.add(new dataFile(405,"Thoubal"));
        Manipur.add(new dataFile(406,"Ukhrul"));

        Meghalaya=new ArrayList<>();

        Meghalaya.add(new dataFile(424,"East Garo Hills"));
        Meghalaya.add(new dataFile(418,"East Jaintia Hills"));
        Meghalaya.add(new dataFile(414,"East Khasi Hills"));
        Meghalaya.add(new dataFile(423,"North Garo Hills"));
        Meghalaya.add(new dataFile(417,"Ri-Bhoi"));
        Meghalaya.add(new dataFile(421,"South Garo Hills"));
        Meghalaya.add(new dataFile(422,"South West Garo Hills"));
        Meghalaya.add(new dataFile(415,"South West Khasi Hills"));
        Meghalaya.add(new dataFile(420,"West Garo Hills"));
        Meghalaya.add(new dataFile(416,"West Jaintia Hills"));
        Meghalaya.add(new dataFile(419,"West Khasi Hills"));

        Mizoram=new ArrayList<>();

        Mizoram.add(new dataFile(425,"Aizawl East"));
        Mizoram.add(new dataFile(426,"Aizawl West"));
        Mizoram.add(new dataFile(429,"Champhai"));
        Mizoram.add(new dataFile(428,"Kolasib"));
        Mizoram.add(new dataFile(432,"Lawngtlai"));
        Mizoram.add(new dataFile(431,"Lunglei"));
        Mizoram.add(new dataFile(427,"Mamit"));
        Mizoram.add(new dataFile(430,"Serchhip"));
        Mizoram.add(new dataFile(433,"Siaha"));

        Nagaland=new ArrayList<>();

        Nagaland.add(new dataFile(434,"Dimapur"));
        Nagaland.add(new dataFile(444,"Kiphire"));
        Nagaland.add(new dataFile(441,"Kohima"));
        Nagaland.add(new dataFile(438,"Longleng"));
        Nagaland.add(new dataFile(437,"Mokokchung"));
        Nagaland.add(new dataFile(439,"Mon"));
        Nagaland.add(new dataFile(435,"Peren"));
        Nagaland.add(new dataFile(443,"Phek"));
        Nagaland.add(new dataFile(440,"Tuensang"));
        Nagaland.add(new dataFile(436,"Wokha"));
        Nagaland.add(new dataFile(442,"Zunheboto"));

        Odisha=new ArrayList<>();

        Odisha.add(new dataFile(445,"Angul"));
        Odisha.add(new dataFile(448,"Balangir"));
        Odisha.add(new dataFile(447,"Balasore"));
        Odisha.add(new dataFile(472,"Bargarh"));
        Odisha.add(new dataFile(454,"Bhadrak"));
        Odisha.add(new dataFile(468,"Boudh"));
        Odisha.add(new dataFile(457,"Cuttack"));
        Odisha.add(new dataFile(473,"Deogarh"));
        Odisha.add(new dataFile(458,"Dhenkanal"));
        Odisha.add(new dataFile(467,"Gajapati"));
        Odisha.add(new dataFile(449,"Ganjam"));
        Odisha.add(new dataFile(459,"Jagatsinghpur"));
        Odisha.add(new dataFile(460,"Jajpur"));
        Odisha.add(new dataFile(474,"Jharsuguda"));
        Odisha.add(new dataFile(464,"Kalahandi"));
        Odisha.add(new dataFile(450,"Kandhamal"));
        Odisha.add(new dataFile(461,"Kendrapara"));
        Odisha.add(new dataFile(455,"Kendujhar"));
        Odisha.add(new dataFile(446,"Khurda"));
        Odisha.add(new dataFile(451,"Koraput"));
        Odisha.add(new dataFile(469,"Malkangiri"));
        Odisha.add(new dataFile(456,"Mayurbhanj"));
        Odisha.add(new dataFile(470,"Nabarangpur"));
        Odisha.add(new dataFile(462,"Nayagarh"));
        Odisha.add(new dataFile(465,"Nuapada"));
        Odisha.add(new dataFile(463,"Puri"));
        Odisha.add(new dataFile(471,"Rayagada"));
        Odisha.add(new dataFile(452,"Sambalpur"));
        Odisha.add(new dataFile(466,"Subarnapur"));
        Odisha.add(new dataFile(453,"Sundargarh"));

        Puducherry=new ArrayList<>();

        Puducherry.add(new dataFile(476,"Karaikal"));
        Puducherry.add(new dataFile(477,"Mahe"));
        Puducherry.add(new dataFile(475,"Puducherry"));
        Puducherry.add(new dataFile(478,"Yanam"));

        Punjab=new ArrayList<>();

        Punjab.add(new dataFile(485,"Amritsar"));
        Punjab.add(new dataFile(483,"Barnala"));
        Punjab.add(new dataFile(493,"Bathinda"));
        Punjab.add(new dataFile(499,"Faridkot"));
        Punjab.add(new dataFile(484,"Fatehgarh Sahib"));
        Punjab.add(new dataFile(487,"Fazilka"));
        Punjab.add(new dataFile(480,"Ferozpur"));
        Punjab.add(new dataFile(489,"Gurdaspur"));
        Punjab.add(new dataFile(481,"Hoshiarpur"));
        Punjab.add(new dataFile(492,"Jalandhar"));
        Punjab.add(new dataFile(479,"Kapurthala"));
        Punjab.add(new dataFile(488,"Ludhiana"));
        Punjab.add(new dataFile(482,"Mansa"));
        Punjab.add(new dataFile(491,"Moga"));
        Punjab.add(new dataFile(486,"Pathankot"));
        Punjab.add(new dataFile(494,"Patiala"));
        Punjab.add(new dataFile(497,"Rup Nagar"));
        Punjab.add(new dataFile(498,"Sangrur"));
        Punjab.add(new dataFile(496,"SAS Nagar"));
        Punjab.add(new dataFile(500,"SBS Nagar"));
        Punjab.add(new dataFile(490,"Sri Muktsar Sahib"));
        Punjab.add(new dataFile(495,"Tarn Taran"));

        Rajasthan=new ArrayList<>();

        Rajasthan.add(new dataFile(507,"Ajmer"));
        Rajasthan.add(new dataFile(512,"Alwar"));
        Rajasthan.add(new dataFile(519,"Banswara"));
        Rajasthan.add(new dataFile(516,"Baran"));
        Rajasthan.add(new dataFile(528,"Barmer"));
        Rajasthan.add(new dataFile(508,"Bharatpur"));
        Rajasthan.add(new dataFile(523,"Bhilwara"));
        Rajasthan.add(new dataFile(501,"Bikaner"));
        Rajasthan.add(new dataFile(514,"Bundi"));
        Rajasthan.add(new dataFile(521,"Chittorgarh"));
        Rajasthan.add(new dataFile(530,"Churu"));
        Rajasthan.add(new dataFile(511,"Dausa"));
        Rajasthan.add(new dataFile(524,"Dholpur"));
        Rajasthan.add(new dataFile(520,"Dungarpur"));
        Rajasthan.add(new dataFile(517,"Hanumangarh"));
        Rajasthan.add(new dataFile(505,"Jaipur I"));
        Rajasthan.add(new dataFile(506,"Jaipur II"));
        Rajasthan.add(new dataFile(527,"Jaisalmer"));
        Rajasthan.add(new dataFile(533,"Jalore"));
        Rajasthan.add(new dataFile(515,"Jhalawar"));
        Rajasthan.add(new dataFile(510,"Jhunjhunu"));
        Rajasthan.add(new dataFile(502,"Jodhpur"));
        Rajasthan.add(new dataFile(525,"Karauli"));
        Rajasthan.add(new dataFile(503,"Kota"));
        Rajasthan.add(new dataFile(532,"Nagaur"));
        Rajasthan.add(new dataFile(529,"Pali"));
        Rajasthan.add(new dataFile(522,"Pratapgarh"));
        Rajasthan.add(new dataFile(518,"Rajsamand"));
        Rajasthan.add(new dataFile(534,"Sawai Madhopur"));
        Rajasthan.add(new dataFile(513,"Sikar"));
        Rajasthan.add(new dataFile(531,"Sirohi"));
        Rajasthan.add(new dataFile(509,"Sri Ganganagar"));
        Rajasthan.add(new dataFile(526,"Tonk"));
        Rajasthan.add(new dataFile(504,"Udaipur"));

        Sikkim=new ArrayList<>();

        Sikkim.add(new dataFile(535,"East Sikkim"));
        Sikkim.add(new dataFile(537,"North Sikkim"));
        Sikkim.add(new dataFile(538,"South Sikkim"));
        Sikkim.add(new dataFile(536,"West Sikkim"));

        TamilNadu=new ArrayList<>();

        TamilNadu.add(new dataFile(779,"Aranthangi"));
        TamilNadu.add(new dataFile(555,"Ariyalur"));
        TamilNadu.add(new dataFile(578,"Attur"));
        TamilNadu.add(new dataFile(565,"Chengalpet"));
        TamilNadu.add(new dataFile(571,"Chennai"));
        TamilNadu.add(new dataFile(778,"Cheyyar"));
        TamilNadu.add(new dataFile(539,"Coimbatore"));
        TamilNadu.add(new dataFile(547,"Cuddalore"));
        TamilNadu.add(new dataFile(566,"Dharmapuri"));
        TamilNadu.add(new dataFile(556,"Dindigul"));
        TamilNadu.add(new dataFile(563,"Erode"));
        TamilNadu.add(new dataFile(552,"Kallakurichi"));
        TamilNadu.add(new dataFile(557,"Kanchipuram"));
        TamilNadu.add(new dataFile(544,"Kanyakumari"));
        TamilNadu.add(new dataFile(559,"Karur"));
        TamilNadu.add(new dataFile(780,"Kovilpatti"));
        TamilNadu.add(new dataFile(562,"Krishnagiri"));
        TamilNadu.add(new dataFile(540,"Madurai"));
        TamilNadu.add(new dataFile(576,"Nagapattinam"));
        TamilNadu.add(new dataFile(558,"Namakkal"));
        TamilNadu.add(new dataFile(577,"Nilgiris"));
        TamilNadu.add(new dataFile(564,"Palani"));
        TamilNadu.add(new dataFile(573,"Paramakudi"));
        TamilNadu.add(new dataFile(570,"Perambalur"));
        TamilNadu.add(new dataFile(575,"Poonamallee"));
        TamilNadu.add(new dataFile(546,"Pudukkottai"));
        TamilNadu.add(new dataFile(567,"Ramanathapuram"));
        TamilNadu.add(new dataFile(781,"Ranipet"));
        TamilNadu.add(new dataFile(545,"Salem"));
        TamilNadu.add(new dataFile(561,"Sivaganga"));
        TamilNadu.add(new dataFile(580,"Sivakasi"));
        TamilNadu.add(new dataFile(551,"Tenkasi"));
        TamilNadu.add(new dataFile(541,"Thanjavur"));
        TamilNadu.add(new dataFile(569,"Theni"));
        TamilNadu.add(new dataFile(554,"Thoothukudi (Tuticorin)"));
        TamilNadu.add(new dataFile(560,"Tiruchirappalli"));
        TamilNadu.add(new dataFile(548,"Tirunelveli"));
        TamilNadu.add(new dataFile(550,"Tirupattur"));
        TamilNadu.add(new dataFile(568,"Tiruppur"));
        TamilNadu.add(new dataFile(572,"Tiruvallur"));
        TamilNadu.add(new dataFile(553,"Tiruvannamalai"));
        TamilNadu.add(new dataFile(574,"Tiruvarur"));
        TamilNadu.add(new dataFile(543,"Vellore"));
        TamilNadu.add(new dataFile(542,"Viluppuram"));
        TamilNadu.add(new dataFile(549,"Virudhunagar"));

        Telangana=new ArrayList<>();

        Telangana.add(new dataFile(582,"Adilabad"));
        Telangana.add(new dataFile(583,"Bhadradri Kothagudem"));
        Telangana.add(new dataFile(581,"Hyderabad"));
        Telangana.add(new dataFile(584,"Jagtial"));
        Telangana.add(new dataFile(585,"Jangaon"));
        Telangana.add(new dataFile(586,"Jayashankar Bhupalpally"));
        Telangana.add(new dataFile(587,"Jogulamba Gadwal"));
        Telangana.add(new dataFile(588,"Kamareddy"));
        Telangana.add(new dataFile(589,"Karimnagar"));
        Telangana.add(new dataFile(590,"Khammam"));
        Telangana.add(new dataFile(591,"Kumuram Bheem"));
        Telangana.add(new dataFile(592,"Mahabubabad"));
        Telangana.add(new dataFile(593,"Mahabubnagar"));
        Telangana.add(new dataFile(594,"Mancherial"));
        Telangana.add(new dataFile(595,"Medak"));
        Telangana.add(new dataFile(596,"Medchal"));
        Telangana.add(new dataFile(612,"Mulugu"));
        Telangana.add(new dataFile(597,"Nagarkurnool"));
        Telangana.add(new dataFile(598,"Nalgonda"));
        Telangana.add(new dataFile(613,"Narayanpet"));
        Telangana.add(new dataFile(599,"Nirmal"));
        Telangana.add(new dataFile(600,"Nizamabad"));
        Telangana.add(new dataFile(601,"Peddapalli"));
        Telangana.add(new dataFile(602,"Rajanna Sircilla"));
        Telangana.add(new dataFile(603,"Rangareddy"));
        Telangana.add(new dataFile(604,"Sangareddy"));
        Telangana.add(new dataFile(605,"Siddipet"));
        Telangana.add(new dataFile(606,"Suryapet"));
        Telangana.add(new dataFile(607,"Vikarabad"));
        Telangana.add(new dataFile(608,"Wanaparthy"));
        Telangana.add(new dataFile(609,"Warangal(Rural)"));
        Telangana.add(new dataFile(610,"Warangal(Urban)"));
        Telangana.add(new dataFile(611,"Yadadri Bhuvanagiri"));

        Tripura=new ArrayList<>();

        Tripura.add(new dataFile(614,"Dhalai"));
        Tripura.add(new dataFile(615,"Gomati"));
        Tripura.add(new dataFile(616,"Khowai"));
        Tripura.add(new dataFile(617,"North Tripura"));
        Tripura.add(new dataFile(618,"Sepahijala"));
        Tripura.add(new dataFile(619,"South Tripura"));
        Tripura.add(new dataFile(620,"Unakoti"));
        Tripura.add(new dataFile(621,"West Tripura"));

        UttarPradesh=new ArrayList<>();

        UttarPradesh.add(new dataFile(622,"Agra"));
        UttarPradesh.add(new dataFile(623,"Aligarh"));
        UttarPradesh.add(new dataFile(625,"Ambedkar Nagar"));
        UttarPradesh.add(new dataFile(626,"Amethi"));
        UttarPradesh.add(new dataFile(627,"Amroha"));
        UttarPradesh.add(new dataFile(628,"Auraiya"));
        UttarPradesh.add(new dataFile(646,"Ayodhya"));
        UttarPradesh.add(new dataFile(629,"Azamgarh"));
        UttarPradesh.add(new dataFile(630,"Badaun"));
        UttarPradesh.add(new dataFile(631,"Baghpat"));
        UttarPradesh.add(new dataFile(632,"Bahraich"));
        UttarPradesh.add(new dataFile(633,"Balarampur"));
        UttarPradesh.add(new dataFile(634,"Ballia"));
        UttarPradesh.add(new dataFile(635,"Banda"));
        UttarPradesh.add(new dataFile(636,"Barabanki"));
        UttarPradesh.add(new dataFile(637,"Bareilly"));
        UttarPradesh.add(new dataFile(638,"Basti"));
        UttarPradesh.add(new dataFile(687,"Bhadohi"));
        UttarPradesh.add(new dataFile(639,"Bijnour"));
        UttarPradesh.add(new dataFile(640,"Bulandshahr"));
        UttarPradesh.add(new dataFile(641,"Chandauli"));
        UttarPradesh.add(new dataFile(642,"Chitrakoot"));
        UttarPradesh.add(new dataFile(643,"Deoria"));
        UttarPradesh.add(new dataFile(644,"Etah"));
        UttarPradesh.add(new dataFile(645,"Etawah"));
        UttarPradesh.add(new dataFile(647,"Farrukhabad"));
        UttarPradesh.add(new dataFile(648,"Fatehpur"));
        UttarPradesh.add(new dataFile(649,"Firozabad"));
        UttarPradesh.add(new dataFile(650,"Gautam Buddha Nagar"));
        UttarPradesh.add(new dataFile(651,"Ghaziabad"));
        UttarPradesh.add(new dataFile(652,"Ghazipur"));
        UttarPradesh.add(new dataFile(653,"Gonda"));
        UttarPradesh.add(new dataFile(654,"Gorakhpur"));
        UttarPradesh.add(new dataFile(655,"Hamirpur"));
        UttarPradesh.add(new dataFile(656,"Hapur"));
        UttarPradesh.add(new dataFile(657,"Hardoi"));
        UttarPradesh.add(new dataFile(658,"Hathras"));
        UttarPradesh.add(new dataFile(659,"Jalaun"));
        UttarPradesh.add(new dataFile(660,"Jaunpur"));
        UttarPradesh.add(new dataFile(661,"Jhansi"));
        UttarPradesh.add(new dataFile(662,"Kannauj"));
        UttarPradesh.add(new dataFile(663,"Kanpur Dehat"));
        UttarPradesh.add(new dataFile(664,"Kanpur Nagar"));
        UttarPradesh.add(new dataFile(665,"Kasganj"));
        UttarPradesh.add(new dataFile(666,"Kaushambi"));
        UttarPradesh.add(new dataFile(667,"Kushinagar"));
        UttarPradesh.add(new dataFile(668,"Lakhimpur Kheri"));
        UttarPradesh.add(new dataFile(669,"Lalitpur"));
        UttarPradesh.add(new dataFile(670,"Lucknow"));
        UttarPradesh.add(new dataFile(671,"Maharajganj"));
        UttarPradesh.add(new dataFile(672,"Mahoba"));
        UttarPradesh.add(new dataFile(673,"Mainpuri"));
        UttarPradesh.add(new dataFile(674,"Mathura"));
        UttarPradesh.add(new dataFile(675,"Mau"));
        UttarPradesh.add(new dataFile(676,"Meerut"));
        UttarPradesh.add(new dataFile(677,"Mirzapur"));
        UttarPradesh.add(new dataFile(678,"Moradabad"));
        UttarPradesh.add(new dataFile(679,"Muzaffarnagar"));
        UttarPradesh.add(new dataFile(680,"Pilibhit"));
        UttarPradesh.add(new dataFile(682,"Pratapgarh"));
        UttarPradesh.add(new dataFile(624,"Prayagraj"));
        UttarPradesh.add(new dataFile(681,"Raebareli"));
        UttarPradesh.add(new dataFile(683,"Rampur"));
        UttarPradesh.add(new dataFile(684,"Saharanpur"));
        UttarPradesh.add(new dataFile(685,"Sambhal"));
        UttarPradesh.add(new dataFile(686,"Sant Kabir Nagar"));
        UttarPradesh.add(new dataFile(688,"Shahjahanpur"));
        UttarPradesh.add(new dataFile(689,"Shamli"));
        UttarPradesh.add(new dataFile(690,"Shravasti"));
        UttarPradesh.add(new dataFile(691,"Siddharthnagar"));
        UttarPradesh.add(new dataFile(692,"Sitapur"));
        UttarPradesh.add(new dataFile(693,"Sonbhadra"));
        UttarPradesh.add(new dataFile(694,"Sultanpur"));
        UttarPradesh.add(new dataFile(695,"Unnao"));
        UttarPradesh.add(new dataFile(696,"Varanasi"));

        Uttarakhand=new ArrayList<>();

        Uttarakhand.add(new dataFile(704,"Almora"));
        Uttarakhand.add(new dataFile(707,"Bageshwar"));
        Uttarakhand.add(new dataFile(699,"Chamoli"));
        Uttarakhand.add(new dataFile(708,"Champawat"));
        Uttarakhand.add(new dataFile(697,"Dehradun"));
        Uttarakhand.add(new dataFile(702,"Haridwar"));
        Uttarakhand.add(new dataFile(709,"Nainital"));
        Uttarakhand.add(new dataFile(698,"Pauri Garhwal"));
        Uttarakhand.add(new dataFile(706,"Pithoragarh"));
        Uttarakhand.add(new dataFile(700,"Rudraprayag"));
        Uttarakhand.add(new dataFile(701,"Tehri Garhwal"));
        Uttarakhand.add(new dataFile(705,"Udham Singh Nagar"));
        Uttarakhand.add(new dataFile(703,"Uttarkashi"));

        WestBengal=new ArrayList<>();

        WestBengal.add(new dataFile(710,"Alipurduar District"));
        WestBengal.add(new dataFile(711,"Bankura"));
        WestBengal.add(new dataFile(712,"Basirhat HD (North 24 Parganas)"));
        WestBengal.add(new dataFile(713,"Birbhum"));
        WestBengal.add(new dataFile(714,"Bishnupur HD (Bankura)"));
        WestBengal.add(new dataFile(715,"Cooch Behar"));
        WestBengal.add(new dataFile(783,"COOCHBEHAR"));
        WestBengal.add(new dataFile(716,"Dakshin Dinajpur"));
        WestBengal.add(new dataFile(717,"Darjeeling"));
        WestBengal.add(new dataFile(718,"Diamond Harbor HD (S 24 Parganas)"));
        WestBengal.add(new dataFile(719,"East Bardhaman"));
        WestBengal.add(new dataFile(720,"Hoogly"));
        WestBengal.add(new dataFile(721,"Howrah"));
        WestBengal.add(new dataFile(722,"Jalpaiguri"));
        WestBengal.add(new dataFile(723,"Jhargram"));
        WestBengal.add(new dataFile(724,"Kalimpong"));
        WestBengal.add(new dataFile(725,"Kolkata"));
        WestBengal.add(new dataFile(726,"Malda"));
        WestBengal.add(new dataFile(727,"Murshidabad"));
        WestBengal.add(new dataFile(728,"Nadia"));
        WestBengal.add(new dataFile(729,"Nandigram HD (East Medinipore)"));
        WestBengal.add(new dataFile(730,"North 24 Parganas"));
        WestBengal.add(new dataFile(731,"Paschim Medinipore"));
        WestBengal.add(new dataFile(732,"Purba Medinipore"));
        WestBengal.add(new dataFile(733,"Purulia"));
        WestBengal.add(new dataFile(734,"Rampurhat HD (Birbhum)"));
        WestBengal.add(new dataFile(735,"South 24 Parganas"));
        WestBengal.add(new dataFile(736,"Uttar Dinajpur"));
        WestBengal.add(new dataFile(737,"West Bardhaman"));







        dateinput = findViewById(R.id.DateInputBox);
        pincodeButton = findViewById(R.id.pincodeRadioButtonBox);
        districtButton = findViewById(R.id.districtNameRadioButtonBox);
        pincodeInput = findViewById(R.id.pincodeNumberBox);
        stateInput = findViewById(R.id.stateSpinnerBox);
        districtInput = findViewById(R.id.DistricttSpinnerBox);
        checkBtn = findViewById(R.id.checkBtnBox);
        pincodeLayout = findViewById(R.id.pincodeLayoutBox);
        districtLayout = findViewById(R.id.DistrtictNameBox);
        radioGroup=findViewById(R.id.radioGroupBox);
        mqueue = Volley.newRequestQueue(this);
        resultsCard=findViewById(R.id.resultsCardViewBox);
        dateinput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar c = Calendar.getInstance();
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int xyear, int xmonth, int xdayOfMonth) {

                        if (xdayOfMonth < 10)
                            day = "0" + String.valueOf(xdayOfMonth);
                        else
                            day = String.valueOf(xdayOfMonth);

                        if (xmonth + 1 < 10)
                            month = "0" + String.valueOf(xmonth + 1);
                        else
                            month = String.valueOf(xmonth + 1);

                        year = String.valueOf(xyear);


                        dateinput.setText(day + "-" + month + "-" + year);

                        dateinput.setError(null);

                    }
                }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();

            }
        });

        pincodeButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    pincodeLayout.setVisibility(View.VISIBLE);
                } else {
                    pincodeLayout.setVisibility(View.GONE);
                }

            }
        });

        districtButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    districtLayout.setVisibility(View.VISIBLE);
                else
                    districtLayout.setVisibility(View.GONE);
            }
        });


//        if (pincodeButton.isChecked())
//        {
//            pincode=String.valueOf(pincodeInput.getText().toString());
//        }

        ArrayAdapter<dataFile> adapter= new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,stateData);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        stateInput.setAdapter(adapter);


        stateInput.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                dataFile selectedState =(dataFile) adapterView.getSelectedItem();

                ArrayList<dataFile> districtData=null;

                if (selectedState.getId()==1)
                    districtData=AndamanandNicobarIslands;
                else if(selectedState.getId()==2)
                    districtData=AndhraPradesh;
                else if(selectedState.getId()==3)
                    districtData=ArunachalPradesh;
                else if(selectedState.getId()==4)
                    districtData=Assam;
                else if(selectedState.getId()==5)
                    districtData=Bihar;
                else if(selectedState.getId()==6)
                    districtData=Chandigarh;
                else if(selectedState.getId()==7)
                    districtData=Chhattisgarh;
                else if(selectedState.getId()==8)
                    districtData=DadraandNagarHaveli;
                else if(selectedState.getId()==37)
                    districtData=DamanandDiu;
                else if(selectedState.getId()==9)
                    districtData=Delhi;
                else if(selectedState.getId()==10)
                    districtData=Goa;
                else if(selectedState.getId()==11)
                    districtData=Gujarat;
                else if(selectedState.getId()==12)
                    districtData=Haryana;
                else if(selectedState.getId()==13)
                    districtData=HimachalPradesh;
                else if(selectedState.getId()==14)
                    districtData=JammuandKashmir;
                else if(selectedState.getId()==15)
                    districtData=Jharkhand;
                else if(selectedState.getId()==16)
                    districtData=Karnataka;
                else if(selectedState.getId()==17)
                    districtData=Kerala;
                else if(selectedState.getId()==18)
                    districtData=Ladakh;
                else if(selectedState.getId()==19)
                    districtData=Lakshadweep;
                else if(selectedState.getId()==20)
                    districtData=MadhyaPradesh;
                else if(selectedState.getId()==21)
                    districtData=Maharashtra;
                else if(selectedState.getId()==22)
                    districtData=Manipur;
                else if(selectedState.getId()==23)
                    districtData=Meghalaya;
                else if(selectedState.getId()==24)
                    districtData=Mizoram;
                else if(selectedState.getId()==25)
                    districtData=Nagaland;
                else if(selectedState.getId()==26)
                    districtData=Odisha;
                else if(selectedState.getId()==27)
                    districtData=Puducherry;
                else if(selectedState.getId()==28)
                    districtData=Punjab;
                else if(selectedState.getId()==29)
                    districtData=Rajasthan;
                else if(selectedState.getId()==30)
                    districtData=Sikkim;
                else if(selectedState.getId()==31)
                    districtData=TamilNadu;
                else if(selectedState.getId()==32)
                    districtData=Telangana;
                else if(selectedState.getId()==33)
                    districtData=Tripura;
                else if(selectedState.getId()==34)
                    districtData=UttarPradesh;
                else if(selectedState.getId()==35)
                    districtData=Uttarakhand;
                else if(selectedState.getId()==36)
                    districtData=WestBengal;


                ArrayAdapter<dataFile> adapter2= new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,districtData);
                adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                districtInput.setAdapter(adapter2);

                districtInput.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        dataFile selesteddistrict =(dataFile) adapterView.getSelectedItem();
                        districtid=String.valueOf(selesteddistrict.getId());


                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if( ((dateinput.getText().toString().isEmpty())&&(radioGroup.getCheckedRadioButtonId() == -1))||(radioGroup.getCheckedRadioButtonId() == -1))
                {
                    if ((dateinput.getText().toString().isEmpty())&&(radioGroup.getCheckedRadioButtonId() == -1))
                        Toast.makeText(MainActivity.this, "Select a date and an option first...", Toast.LENGTH_SHORT).show();
                    else if ((radioGroup.getCheckedRadioButtonId() == -1))
                        Toast.makeText(MainActivity.this, "Select an option", Toast.LENGTH_SHORT).show();
                }

                if (pincodeButton.isChecked())
                {
                    if ((dateinput.getText().toString().isEmpty()) || (pincodeInput.getText().toString().isEmpty()))
                    {
                        if (dateinput.getText().toString().isEmpty())
                            dateinput.setError("Select Date");

                        if (pincodeInput.getText().toString().isEmpty())
                            pincodeInput.setError("Enter Pincode");
                    }else
                    {
                        date=dateinput.getText().toString();
                        pincode=pincodeInput.getText().toString();

                        populateResultView(date,pincode,null);


                    }
                }
                else if (districtButton.isChecked())
                {
                    if (dateinput.getText().toString().isEmpty())
                        dateinput.setError("Select Date");
                    else
                    {
                        date=dateinput.getText().toString();

                        populateResultView(date,null,districtid);

                    }
                }






            }
        });

    }

    public void populateResultView(String date, String pincode,String districtid)
    {
        String url=null;
        resultList=new ArrayList<>();
        if (pincode!=null)
            url = "https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByPin?pincode="+pincode+"&date="+date;
        else
            url ="https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByDistrict?district_id="+districtid+"&date="+date;

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray jsonArray = response.getJSONArray("sessions");

                    if (jsonArray.length()<=0) {
                        Toast.makeText(MainActivity.this, "No available slots", Toast.LENGTH_SHORT).show();
                        resultsCard.setVisibility(View.GONE);
                        return;
                    }
                    resultsCard.setVisibility(View.VISIBLE);

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject data = jsonArray.getJSONObject(i);
                        String center_id=data.getString("center_id");
                        String center_name = data.getString("name");
                        String address = data.getString("address");
                        String state_name = data.getString("state_name");
                        String district_name = data.getString("district_name");
                        String block_name = data.getString("block_name");
                        String pincode = data.getString("pincode");
                        String timing_from = data.getString("from");
                        String timing_to = data.getString("to");
                        String fee_type = data.getString("fee_type");
                        String date = data.getString("date");
                        String fee = data.getString("fee");
                        String available_capacity = data.getString("available_capacity");
                        String dose1=data.getString("available_capacity_dose1");
                        String dose2=data.getString("available_capacity_dose2");
                        String min_age_limit = data.getString("min_age_limit");
                        String vaccine = data.getString("vaccine");

                        JSONArray slotsValue = data.getJSONArray("slots");
                        String slots="No slots available";
                        if (slotsValue.length()>0) {
                            slots="";
                            for (int k = 0; k < slotsValue.length(); k++) {
                                slots = slots + slotsValue.getString(k) + "\n";
                            }
                        }

                        objectData obj =new objectData(center_id,center_name,address,state_name,district_name,block_name,pincode,timing_from,timing_to,fee_type,date,fee,available_capacity,dose1,dose2,min_age_limit,vaccine,slots);


                        resultList.add(obj);

                    }
                    initialize_recycler_view();


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Something went wrong...", Toast.LENGTH_SHORT).show();
            }
        });


        mqueue.add(request);
    }

    private void initialize_recycler_view() {


        resultView = findViewById(R.id.resultRecyclerView);
        resultView.setNestedScrollingEnabled(false);
        resultView.setHasFixedSize(false);
        result_list_layout_manager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
        resultView.setLayoutManager(result_list_layout_manager);
        result_list_adapter = new resultListAdapter(getApplicationContext(), resultList);
        resultView.setAdapter(result_list_adapter);

    }
}