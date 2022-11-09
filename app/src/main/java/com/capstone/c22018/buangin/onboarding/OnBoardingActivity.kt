package com.capstone.c22018.buangin.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.capstone.c22018.buangin.R
import com.capstone.c22018.buangin.databinding.ActivityOnBoardingBinding
import com.capstone.c22018.buangin.login.LoginActivity
import com.capstone.c22018.buangin.onboarding.adapter.OnBoardingAdapter
import com.capstone.c22018.buangin.register.RegisterActivity

class OnBoardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnBoardingBinding
    private lateinit var onBoardingAdapter: OnBoardingAdapter
    private lateinit var indicatorsContainer: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setOnboardingItems()
        setupIndicators()
        setCurrentIndicator(0)
        setActionButton()
    }

        private fun setActionButton() {

            binding.btnLogin.setOnClickListener {
                startActivity(Intent(this, LoginActivity::class.java))
            }

            binding.btnRegister.setOnClickListener {
                startActivity(Intent(this, RegisterActivity::class.java))
            }

        }

        private fun setOnboardingItems() {
            onBoardingAdapter = OnBoardingAdapter(
                listOf(
                    OnBoardingItem(
                        R.drawable.img_onbrd1,
                        resources.getString(R.string.title_onboarding),
                        resources.getString(R.string.desc_onbrd1)
                    ),
                    OnBoardingItem(
                        R.drawable.img_onbrd2,
                        resources.getString(R.string.title_onboarding),
                        resources.getString(R.string.desc_onbrd2)
                    ),
                    OnBoardingItem(
                        R.drawable.img_onbrd3,
                        resources.getString(R.string.title_onboarding),
                        resources.getString(R.string.desc_onbrd3)
                    ),
                    OnBoardingItem(
                        R.drawable.img_onbrd4,
                        resources.getString(R.string.title_onboarding),
                        resources.getString(R.string.desc_onbrd4)
                    )
                )
            )

            val onboardingViewPager = findViewById<ViewPager2>(R.id.onboardingViewPager)
            onboardingViewPager.adapter = onBoardingAdapter
            onboardingViewPager.registerOnPageChangeCallback(object:
                ViewPager2.OnPageChangeCallback(){

                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    setCurrentIndicator(position)
                }

            })
            (onboardingViewPager.getChildAt(0) as RecyclerView).overScrollMode =
                RecyclerView.OVER_SCROLL_NEVER
        }

        private fun setupIndicators() {
            indicatorsContainer = findViewById(R.id.indicatorContainer)
            val indicators = arrayOfNulls<ImageView>(onBoardingAdapter.itemCount)
            val layoutParams: LinearLayout.LayoutParams =
                LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
            layoutParams.setMargins(8, 0, 8,0)
            for (i in indicators.indices) {
                indicators[i] = ImageView(applicationContext)
                indicators[i]?.let {
                    it.setImageDrawable(
                        ContextCompat.getDrawable(
                            applicationContext,
                            R.drawable.indicator_inactive_background
                        )
                    )
                    it.layoutParams = layoutParams
                    indicatorsContainer.addView(it)
                }
            }
        }

        private fun setCurrentIndicator(position: Int) {
            val childCount = indicatorsContainer.childCount
            for (i in 0 until childCount) {
                val imageView = indicatorsContainer.getChildAt(i) as ImageView
                if (i == position) {
                    imageView.setImageDrawable(
                        ContextCompat.getDrawable(
                            applicationContext,
                            R.drawable.indicator_active_background
                        )
                    )
                } else {
                    imageView.setImageDrawable(
                        ContextCompat.getDrawable(
                            applicationContext,
                            R.drawable.indicator_inactive_background
                        )
                    )
                }
            }
        }

    }