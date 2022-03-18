package com.apion.apionhome.ui.home.FragmentDashboard

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.apion.apionhome.R
import com.apion.apionhome.data.model.Feature
import com.apion.apionhome.ui.home.adaper.AroundHaNoiAdapter
import com.apion.apionhome.ui.home.adaper.AroundSaiGonAdapter
import com.apion.apionhome.ui.home.adaper.HighlightAdapter
import com.apion.apionhome.ui.home.adaper.PhotoAdapter
import com.apion.apionhome.ui.search.BottomSheetPrice
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_dashboard.view.*


class DashboardFragment(val mContext: Activity) : Fragment(),DashboardContract.View {
    private val sliderHandler = Handler(Looper.getMainLooper())
    lateinit var viewPager : ViewPager2
    lateinit var tabLayout : TabLayout
    lateinit var rv_landHighlight : RecyclerView
    lateinit var rv_aroundHanoi : RecyclerView
    lateinit var rv_aroundSaiGon : RecyclerView
    //khai báo list item
    var list         = ArrayList<String>()
    var list_Feature = ArrayList<Feature>()
    var list_Hanoi   = ArrayList<Feature>()
    var list_SaiGon  = ArrayList<Feature>()
    // adapter
    var photoAdapter : PhotoAdapter? = null
    var featureAdapter: HighlightAdapter? = null
    var hanoiAdapter: AroundHaNoiAdapter? = null
    var saigonAdapter: AroundSaiGonAdapter? = null

    var runnable : Runnable = Runnable{
            var current = viewPager.currentItem
            if(list.size-1 == current){
                current = 0
            } else
            {
                current++
            }
            viewPager.currentItem = current

    }

    override var presenter: DashboardContract.Presenter = DashboardPresenter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_dashboard, container, false)

        presenter.start()
        setupListener(view)
        setBanner(view)
        setHighlight(view)
        setAroundHaNoi(view)
        setAroundSaiGon(view)
        return view
    }

    fun setupListener(view: View){
        view.editTextCity.setOnClickListener(View.OnClickListener {
            println("Ban da chon gia")})

        view.editTextDistrict.setOnClickListener(View.OnClickListener {

        })
        view.editTextPrice.setOnClickListener(View.OnClickListener {
            setupBottomSheet(R.layout.bottomsheet_price)
        })
        view.editTextSquare.setOnClickListener(View.OnClickListener {
            setupBottomSheet(R.layout.bottomsheet_square)
        })

        view.layout_ward_street.setOnClickListener(View.OnClickListener {
            println("Ok duoc roi")
        })


    }
    fun setupBottomSheet(layout: Int){
        val viewDialog: View = layoutInflater.inflate(layout, null)
//        val bottomSheetDialog = BottomSheetDialog(requireContext(), R.style.SheetDialog)
//        bottomSheetDialog.setContentView(viewDialog)
//        bottomSheetDialog.show()
        val bottomSheetDialog = BottomSheetPrice()
        bottomSheetDialog.show(requireFragmentManager(),"abc")
    }

    fun setBanner(view: View){
        viewPager = view.findViewById(R.id.viewPager)
        tabLayout = view.findViewById(R.id.tabLayout) as TabLayout
        photoAdapter = PhotoAdapter(list,mContext)
        viewPager?.setAdapter(photoAdapter)
        TabLayoutMediator(tabLayout,viewPager){ _, _ ->
        }.attach()

        viewPager?.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                sliderHandler.removeCallbacks(runnable)
                sliderHandler.postDelayed(runnable, 3000)
            }
        })
    }
    fun setHighlight(view:View){
        rv_landHighlight = view.findViewById(R.id.land_highlights)
        rv_landHighlight.layoutManager= LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        featureAdapter = HighlightAdapter(list_Feature,mContext)
        rv_landHighlight.adapter = featureAdapter

    }
    fun setAroundHaNoi(view : View){
        rv_aroundHanoi = view.findViewById(R.id.arround_HaNoi)
        rv_aroundHanoi.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        hanoiAdapter = AroundHaNoiAdapter(list_Hanoi,mContext)
        rv_aroundHanoi.adapter = hanoiAdapter

    }
    fun setAroundSaiGon(view : View){
        rv_aroundSaiGon = view.findViewById(R.id.arround_SaiGon)
        rv_aroundSaiGon.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        saigonAdapter = AroundSaiGonAdapter(list_SaiGon,mContext)
        rv_aroundSaiGon.adapter = saigonAdapter

    }

    override fun updateListImage(list_url:ArrayList<String>){
        for (i in 0 until list_url.size) {
            list.add(list_url.get(i))
        }
        photoAdapter?.notifyDataSetChanged()
    }
    override fun updateListLandHigh(list_feature: ArrayList<Feature>){
        for (i in 0 until list_feature.size) {
            list_Feature.add(list_feature.get(i))
        }
        featureAdapter?.notifyDataSetChanged()
    }
    override fun updateHanoi(list_hanoi: ArrayList<Feature>) {
        for (i in 0 until list_hanoi.size) {
            list_Hanoi.add(list_hanoi.get(i))
        }
        hanoiAdapter?.notifyDataSetChanged()
    }
    override fun updateSaiGon(list_saigon: ArrayList<Feature>) {
        for (i in 0 until list_saigon.size) {
            list_SaiGon.add(list_saigon.get(i))
        }
        saigonAdapter?.notifyDataSetChanged()
    }

}



