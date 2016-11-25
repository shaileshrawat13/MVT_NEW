/*
 * Copyright (C) 2013 Andrew Neal
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package shaileshrawat.mvt;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.ref.WeakReference;
import java.util.Arrays;

/**
 * @author Andrew Neal (andrewdneal@gmail.com)
 */
public class modiPolitcalComparison extends ListFragment implements OnItemClickListener {

    /**
     * List content
     */
    private static final String[] MOVIES = new String[] {
            "\nCrime\n"+
                    "\tRoll out a comprehensive strategy for bringing the Indian Police at par with international standards.\n" +
                    "\tFacilitate training and capacity building of Police forces.\n" +
                    "\tModernize the police force, equipping them with the latest technology.\n" +
                    "\tInitiate the networking of police stations across the country for intelligence sharing and crime control.\n" +
                    "\tStrengthen Investigations, making them Swift, Transparent, Fair, Clear and Decisive - acting as an inescapable deterrent to wrong- doers and a protective shield to the innocent.\n" +
                    "\tDevelop specialized expertise in investigation; through continuous training, especially in evolving competencies.\n" +
                    "\tOverhaul our intelligence set up, with special focus on coordination and integration of human and technological intel - comprehensively gearing it towards collecting real time, specific and actionable inputs.\n" +
                    "\tModernize our Prison system with technology and infrastructure; to strengthen the security as well human rights and correctional dimensions.\n" +
                    "\tWork towards evolving common national standards and protocols.\n" +
                    "\tTrain and technologically enable the police to track, pursue, as well as prevent Cyber Crime.\n" +
                    "\tBring Coastal States together on a common platform to discuss issues of Marine Policing.\n" +
                    "\tReinterpret the age-old concept of community policing in modern times; evolving ways for the police to reach out to the people, building bonds of trust and friendship - including spreading out into areas of public safety and public wellness.\n" +
                    "\tGive special emphasis for improving the working conditions and welfare of police personnel.\n",
            "\nEnvironment\n" +
                    "\tLaunch the 'Pradhan Mantri Gram Sinchayee Yojana' with a motto of 'har khet ko paani'. We will launch multi-pronged 'water strategy' for reducing farmer's dependence on monsoon. Increase irrigated land by completing the long pending irrigation projects on priority.\n" +
                    "\tWe will nurture ground water recharge harnessing rain water to reduce dependence on groundwater.\n" +
                    "\tEncourage efficient use, water conservation, recycling and rain water harvesting.\n" +
                    "\tSewage treatment plants to prevent the pollution of rivers.\n" +
                    "\tDesalination plants for drinking water supply in coastal cities.\n" +
                    "\tInter-linking of rivers based on feasibility.\n" +
                    "\tExamination of ground water to eliminate toxic chemicals, particularly arsenic and fluorides.\n" +
                    "\tTo ensure drinking water security to all. We will:\n" +
                    "\tEncourage setting up of drinking water supply grid in water scarce areas.\n" +
                    "\tPromote decentralized, demand-driven, community-managed water resource management, water supply and environmental sanitation.\n" +
                    "\tFacilitate piped water to all households.\n" +
                    "\tCome out with a responsible and comprehensive 'National Energy Policy'.\n" +
                    "\tFocus on development of energy infrastructure, human resource development and upgradation of technology.\n" +
                    "\tTake steps to maximize the potential of oil, gas, hydel power, ocean, wind, coal and nuclearsources. BJP considers energy efficiency and conservation crucial to energy security.\n" +
                    "\tSet up small-hydro power generation projects to harness the hydropower that is not being used at the moment. Small projects can be set up with local support and without displacement of the local population.\n" +
                    "\tTake Steps to increase the domestic coal exploration and production, to bridge the demand and supply gap.\n " +
                    "\tOil and gas explorations would also be expedited in the country. This will also help to reduce the import bill.\n" +
                    "\tGive a thrust to renewable sources of energy as an important component of India's energy mix.\n" +
                    "\tExpand and strengthen the national solar mission. Encourage Cleaner production.\n" +
                    "\tCleaner fuels will be promoted so as to bring down the pollution levels particularly in the cities.\n" +
                    "\tThe concept of pro-active 'Carbon Credit' will be promoted.\n" +
                    "\tEcological Audit of projects and pollution indexing of cities and townships will be done on scientific basis.\n" +
                    "\tPollution control mechanisms will be set up on priority basis.\n" +
                    "\tIn addition to protecting the existing forests and wildlife reserves, the wastelands of the country will be used for social forestry.\n" +
                    "\tGuidelines for Green buildings and energy efficient work places will be brought out.\n" +
                    "\tR&D and Human Resource Development in Environment Technology will be promoted.\n" +
                    "\tSet up fool proof mechanisms for protection and preservation of wild life.\n" +
                    "\tEncourage citizen's participation in reforestation, agro-forestry and social forestry, through targeted programmes.\n" +
                    "\tEncourage and incentivize innovative garbage disposal and waste management practices, especially recycling techniques.\n" +
                    "\tLaunch 'National Mission on Himalayas' as a unique programme of inter-governmental partnership, in coordinated policy making and capacity building across states and sectors.\n" +
                    "\tCreate a 'Himalayan Sustainability Fund'.\n" +
                    "\tCreate a Central University dedicated to the Himalayan Technology.\n" +
                    "\tGive due Importance to the programmes devised to arrest the melting of Himalayan glaciers from which most of the rivers in North India originate\n" +
                    "\tWe will set in place national policies on critical natural resources like coal, minerals, spectrum, etc. - spelling out in black and white how much should be utilized at what time and pace; how this should be strategically phased out to ensure sustainability; who should be allotted what responsibility of extraction and at what cost.\n" +
                    "\tState Governments will be taken into confidence for harnessing of these resources.\n" +
                    "\tWe will implement auction of precious resources through efficient mechanisms including e-auction.\n" +
                    "\tResource mapping, exploration and management will be undertaken through the use of technology.\n" +
                    "\tValue addition will be encouraged in all resources, instead of just marketing\n",
            "\nFamilies\n" +
                    "\tLay special emphasis on vulnerable children and especially those belonging to the vulnerable communities like SCs, STs, OBCs, migrants, slum dwellers, street dwellers and those with disabilities.\n" +
                    "\tEnsure effective implementation of the Right to Education, Right to Food Security Act.\n" +
                    "\tReview, amend and strengthen the Child and Adolescent Labour (Prohibition and Regulation) Act,\n" +
                    "\t2012 and Integrated Child Protection Scheme (ICPS).\n" +
                    "\tFocused efforts will be made to address issue of anaemia.\n" +
                    "\tReduce the burden of books on children without compromising on the quality of education.\n" +
                    "\tEndeavour to inculcate values amongst children.\n" +
                    "\tProvide financial support, exploring ideas like additional tax benefits and higher interest rates.\n" +
                    "\tInvest in setting up and improving old-age homes.\n" +
                    "\tHarness their experience in the National Interest. Devise schemes and programs to engage the senior citizens as volunteers / part time workers in various development programmes of the government, in urban and rural areas. This will not only help in utilizing their time, but also it would be an effective utilization of their experience and may add an additional source of income for them.\n" +
                    "\tEnact the 'Rights of the Persons with Disabilities bill' (RPWD).\n" +
                    "\tUse technology to deliver low cost quality education to specially-abled students 'in-home' – through E-learning.\n" +
                    "\tIdentify each and every special needs person across the country - establishing a web based disability registration system to issue universal ID for all applicable government benefits (healthcare, transportation, jobs, education etc).\n" +
                    "\tEnsure disabled friendly access to public facilities, public buildings and transport.\n" +
                    "\tEnsure maximum economic independence of the disabled by creating more income generation models for them.\n" +
                    "\tSupport and aid voluntary organizations working for the care of the disabled.\n" +
                    "\tProvide a higher tax relief for the family member taking care of the disabled.\n" +
                    "\tWe will initiate the 'Young Leaders programme' in all sectors, to recognize, reward and involve these exceptionally talented youth to serve as role models and mentors for others.\n" +
                    "\tSet up the National Youth Advisory Council.\n" +
                    "\tBJP will initiate nation-wide 'district level incubation and accelerator programme' for encouraging innovation and entrepreneurship.\n" +
                    "\tProcedure to avail Student's loans will be simplified and loans made affordable.\n" +
                    "\tSet up neighbourhood Children's/ Youth Parliament across India that leads to vibrant student committees.\n" +
                    "\tWill launch a programme, 'Youth for Development'.\n",
            "\nForeign Policy\n" +
                    "\tEquations will be mended through pragmatism and a doctrine of mutually beneficial and interlocking relationships, based on enlightened national interest.\n" +
                    "\tWe will champion uniform international opinion on issues like Terrorism and Global Warming.\n" +
                    "\tInstead of being led by big power interests, we will engage proactively on our own with countries in the neighbourhood and beyond.\n" +
                    "\tIn our neighbourhood we will pursue friendly relations. However, where required we will not hesitate from taking strong stand and steps.\n" +
                    "\tWe will work towards strengthening Regional forums like SAARC and ASEAN.\n" +
                    "\tWe will continue our dialogue, engagement and cooperation, with global forums like BRICS, G20. IBSA, SCO and ASEM. States will be encouraged to play a greater role in diplomacy; actively building relations with foreign countries to harness their mutual cultural and commercial strengths.\n" +
                    "\tWe will expand and empower our pool of diplomats, ensuring our message is taken to the world and our great nation represented on the whole in a befitting manner.\n" +
                    "\tThe NRIs, PIOs and professionals settled abroad are a vast reservoir to articulate the national interests and affairs globally. This resource will be harnessed for strengthening Brand India.\n" +
                    "\tIndia shall remain a natural home for persecuted Hindus and they shall be welcome to seek refuge here.\n",
            "\nGovernment\n" +
                    "\tDigitization of Government records will be taken up on top priority so that they are easily accessible.\n" +
                    "\tPerformance review, social and environment audit would be mandated for all Government schemes and programmes.\n" +
                    "\tOpen up Government to draw expertise from the industry, academia and society into the services.\n" +
                    "\tGovernment will be redefined by elimination of whatever is obsolete in laws, regulations, administrative structures, practices and would be purposive.\n" +
                    "\tWe will generate 'Kartavya Bhavna' among public servants as lives and productivity of people is dependent on the quality and efficiency of public services.\n" +
                    "\tPeople-centric\n" +
                    "\tPolicy driven\n" +
                    "\tTime bound delivery\n" +
                    "\tMinimum Government, Maximum Governance\n" +
                    "\tFocus on increasing the penetration and usage of broadband across the country. Deployment of broadband in every village would be a thrust area.\n" +
                    "\tLeverage technology for e-Governance and engage proactively with the people through social media for participative governance and effective public grievance redressal mechanism.\n" +
                    "\tGenerate IT based jobs in rural and semi-urban areas.\n" +
                    "\tMake technology enabled products affordable for students.\n" +
                    "\tUse technology to reduce the burden of books on children. Make all institutions and schools e-enabled in a phased manner. Digital learning and training to be used extensively.\n" +
                    "\tPursue a mission mode project under the 'National Rural Internet and Technology Mission' for useof telemedicine and mobile healthcare for rural healthcare delivery; use of IT for agriculture for real time information; Self Help Groups; retail trade and SMEs; and rural entrepreneurs, etc.\n" +
                    "\tInitiate a National e-Governance Plan to cover every Government office from the centre to the panchayats. The 'E-Gram, Vishwa Gram' scheme in Gujarat to be implemented nationwide.\n" +
                    "\tPromote e-Bhasha - National Mission for the promotion of IT in Indian Languages.\n" +
                    "\tFocus to bring SC/ST, OBCs and other weaker sections of the society within the ambit of IT enabled development.\n" +
                    "\tDeploy IT to protect India's priceless cultural and artistic heritage, which includes digitization of all archives and museology.\n" +
                    "\tPromote 'open source' and 'open standard' software.\n" +
                    "\tMandate digitization of all government work to reduce corruption and delays.\n" +
                    "\tSet up High-speed digital highways to unite the nation.\n" +
                    "\tUse technology to reduce Transmission and distribution losses.\n" +
                    "\tUse mobile and e-Banking to ensure financial inclusion.\n",
            "\nHealthcare\n" +
                    "\tInitiate the 'National Health Assurance Mission', with a clear mandate to provide universal healthcare that is not only accessible and affordable, but also effective, and reduces the OOP spending for the common man.\n" +
                    "\tEducation and Training - Will review the role of various professional regulatory bodies in healthcare and consider setting up an overarching lean body for healthcare. High priority will be given to address the shortfall of healthcare professionals.\n" +
                    "\tModernize Government hospitals, upgrading infrastructure and latest technologies.\n" +
                    "\tReorganize Ministry of Health and Family Welfare in order to converge various departments dealing in healthcare, food and nutrition and pharmaceuticals, for effective delivery of healthcare services.\n" +
                    "\tIncrease the number of medical and para-medical colleges to make India self sufficient in human resources, and set up an AIIMS like institute in every state.\n" +
                    "\tYoga and Ayurveda are the gifts of ancient Indian civilization to humanity and we will increase the public investment to promote Yoga and AYUSH. We will start integrated courses for Indian System of Medicine (ISM) and modern science and Ayurgenomics. We will set up institutions and launch a vigorous program to standardize and validate the Ayurvedic medicine.\n" +
                    "\tMove to pre-emptive care model where the focus and thrust will be on child health and prevention.\n" +
                    "\tSchool health program would be a major focus area, and health and hygiene will be made a part of the school curriculum.\n" +
                    "\tFocus on Rural Health care delivery.\n" +
                    "\tSenior Citizens healthcare would be a special focus area.\n" +
                    "\tGive high priority to chronic diseases, and will invest in research and development of solutions for chronic diseases like obesity, diabetes, cancer, CVD etc.\n" +
                    "\tOccupational health programs will be pursued aggressively.\n" +
                    "\tUtilize the ubiquitous platform of mobile phones for healthcare delivery and set up the 'National e-Health Authority' to leverage telemedicine and mobile healthcare for expanding reach and coverage and to define the standards and legal framework for technology driven care.\n" +
                    "\tUniversalization of emergency medical services-108.\n" +
                    "\tRe-orientation of herbal plants board to encourage farming of herbal plants.\n" +
                    "\tPopulation stabilization would be a major thrust area and would be pursued as a mission mode program.\n" +
                    "\tProgramme for Women Healthcare with emphasis on rural, SC, ST and OBC in a mission mode.\n" +
                    "\tMission mode project to eradicate malnutrition.\n" +
                    "\tLaunch National Mosquito Control mission.\n" +
                    "\tCreate an open defecation free India by awareness campaign and enabling people to build toilets in their home as well as in schools and public places.\n" +
                    "\tSet up modern, scientific sewage and waste management systems.\n" +
                    "\tWe will introduce Sanitation Ratings measuring and ranking our cities and towns on 'sanitation'; and rewarding the best performers.\n" +
                    "\tMake potable drinking water available to all thus reducing water-borne diseases, which will automatically translate into Diarrhoea-free India.\n",
            "\nJobs & Economy\n" +
                    "\tStrategically develop high impact domains like Labour-intensive manufacturing (viz. textile, footwear, electronics assembly, etc.) and Tourism.\n" +
                    "\tStrengthen the traditional employment bases of agriculture and allied industries, and retail -through modernization as well as stronger credit and market linkages.\n" +
                    "\tHarness the opportunities provided by the upgradation of infrastructure and housing, for its job generating potential.\n" +
                    "\tEncourage and empower our youth for self-employment - incubating entrepreneurship as well as facilitating credit.\n" +
                    "\tAddress the employability issue by initiating a multi-skills development programme in mission mode. Focus will be on job creation and entrepreneurship, in both rural and urban areas.\n" +
                    "\tTransform our Employment Exchanges into Career Centres - connecting our youth with job opportunities in a transparent and effective manner through the use of technology; as well as providing counselling and training.\n",
            "\nScience & Tech\n" +
                    "\tEnsuring food, agricultural, nutritional and environmental, wealth, health and energy security of the people on a sustainable basis, using science and technology.\n" +
                    "\tMounting a direct and sustained effort on the alleviation of poverty, enhancing livelihood security, removal of hunger and malnutrition, reduction of drudgery and regional imbalances, both rural and urban, and generation of employment, by using scientific and technological capabilities along with our traditional knowledge pool.\n" +
                    "\tEncouraging research and innovation in areas of relevance for the economy and society, particularly by promoting close and productive interaction between private and public institutions. Sectors such as agriculture (particularly soil, water management, human and animal nutrition and fisheries), water, health, education, industry, energy including renewable energy, communication and transportation would be accorded highest priority. Leveraging of technologies such as information technology, biotechnology and material sciences would be done with special importance.\n" +
                    "\tEncouraging research and application to meet the challenges of climate change and for forecasting, prevention and mitigation of natural hazards, particularly floods, cyclones, earthquakes, drought and landslides.\n" +
                    "\tPromoting international science and technology cooperation towards achieving the goals of national development and security, and making it a key element of our international relations.\n" +
                    "\tDevise schemes, programs and opportunities to encourage the youth to take scientific research and innovation as a career.\n" +
                    "\tProvide work environment and professional opportunities in fundamental scientific research, to make research careers more appealing, so that the nation can harness the best of brains for scientific research leading to enhancing the national productivity and competitiveness and reverse brain drain.\n" +
                    "\tBuild world class, regional centres of excellence of scientific research in the field of nanotechnology, material sciences, thorium technology and brain research.\n" +
                    "\tCreate an ecosystem for multi-country and inter-disciplinary collaborative research, and establish an Intellectual Property Rights Regime which maximizes the incentive for generation and protection of intellectual property for all type of inventors.\n" +
                    "\tAchieving synergy between industry and scientific research. Autonomous technology transfer organizations will be created as associate organizations of universities and national  laboratories to transfer the know-how generated by them to industry. Industry will be encouraged to adopt or support educational and research institutions to help direct science and technology endeavours towards tangible industrial goals.\n" +
                    "\tPromotion of innovation by creating a comprehensive national system of innovation.\n" +
                    "\tIndigenous knowledge, based on our long and rich tradition will be further developed and harnessed for the purpose of wealth and employment generation\n" +
                    "\tTo promote science popularization schemes extensively.\n" +
                    "\tBring the changes in secondary education to focus on application of science.\n" +
                    "\tSet an institute of Big data and Analytics for studying the impact of big data across sectors for predictive science.\n" +
                    "\tTo do research for the eradication of tropical diseases.\n" +
                    "\tEstablish institutes of Technology for Rural Development.\n" +
                    "\tEstablish a Central University dedicated to Himalayan Technology\n",
            "\nTaxes\n" +
                    "\tProvide a non adversarial and conducive tax environment\n" +
                    "\tRationalize and simplify the tax regime\n" +
                    "\tOverhaul the dispute resolution mechanisms\n" +
                    "\tBring on board all State governments in adopting GST, addressing all their concerns\n" +
                    "\tProvide tax incentives for investments in research and development, geared towards indigenization of technology and innovation"

    };

    /**
     * The header to bind the {@link BackScrollManager} to
     */
    private CarouselContainer mCarousel;

    /**
     * Empty constructor as per the {@link Fragment} docs
     */
    public modiPolitcalComparison() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mCarousel = (CarouselContainer) activity.findViewById(R.id.carousel_header);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Simple ArrayAdapter
        Arrays.sort(MOVIES);
        final CarouselListAdapter adapter = new CarouselListAdapter(getActivity());
        for (final String movie : MOVIES) {
            adapter.add(movie);
        }

        // Bind the data
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final ListView listView = getListView();
        // Attach the BackScrollManager
        listView.setOnScrollListener(new BackScrollManager(mCarousel, null,
                CarouselContainer.TAB_INDEX_FIRST));
        // Register the onItemClickListener
        listView.setOnItemClickListener(this);
        // We disable the scroll bar because it would otherwise be incorrect
        // because of the hidden
        // header
        listView.setVerticalScrollBarEnabled(false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // This is the header
        if (position == 0) {
            return;
        }

        // Remember to substract one from the touched position
        final String movie = (String) parent.getItemAtPosition(position - 1);
        Toast.makeText(getActivity(), movie, Toast.LENGTH_SHORT).show();
    }

    private static final class CarouselListAdapter extends ArrayAdapter<String> {

        /**
         * The header view
         */
        private static final int ITEM_VIEW_TYPE_HEADER = 0;

        /**
         * * The data in the list.
         */
        private static final int ITEM_VIEW_TYPE_DATA = 1;

        /**
         * Number of views (TextView, CarouselHeader)
         */
        private static final int VIEW_TYPE_COUNT = 2;

        /**
         * Fake header
         */
        private final View mHeader;

        /**
         * Constructor of <code>CarouselListAdapter</code>
         *
         * @param context The {@link Context} to use
         */
        public CarouselListAdapter(Context context) {
            super(context, 0);
            // Inflate the fake header
            mHeader = LayoutInflater.from(context).inflate(R.layout.faux_carousel, null);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Return a faux header at position 0
            if (position == 0) {
                return mHeader;
            }

            // Recycle ViewHolder's items
            ViewHolder holder;
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(
                        android.R.layout.simple_list_item_1, parent, false);
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            // Retieve the data, but make sure to call one less than the current
            // position to avoid counting the faux header.
            final String movies = getItem(position - 1);
            holder.mLineOne.get().setText(movies);
            holder.mLineOne.get().setTextSize(15);
            holder.mLineOne.get().setTypeface(null, Typeface.BOLD_ITALIC);
            return convertView;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean hasStableIds() {
            return true;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int getCount() {
            return MOVIES.length + 1;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public long getItemId(int position) {
            if (position == 0) {
                return -1;
            }
            return position - 1;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int getViewTypeCount() {
            return VIEW_TYPE_COUNT;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int getItemViewType(int position) {
            if (position == 0) {
                return ITEM_VIEW_TYPE_HEADER;
            }
            return ITEM_VIEW_TYPE_DATA;
        }
    }

    private static final class ViewHolder {

        public WeakReference<TextView> mLineOne;

        /* Constructor of <code>ViewHolder</code> */
        public ViewHolder(View view) {
            // Initialize mLineOne
            mLineOne = new WeakReference<TextView>((TextView) view.findViewById(android.R.id.text1));
        }

    }

}
